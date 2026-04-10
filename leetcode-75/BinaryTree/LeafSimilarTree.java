package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class LeafSimilarTree{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tree 1 nodes in level order (-1 for null):");
        String[] input1 = sc.nextLine().split(" ");
        TreeNode root1 = buildTree(input1);
        System.out.println("Enter tree 1 nodes in level order (-1 for null):");
        String[] input2 = sc.nextLine().split(" ");
        TreeNode root2 = buildTree(input2);
        sc.close();

        Sol34 sol = new Sol34();
        System.out.println("Leaf Similar Trees?: " + sol.leafSimilar(root1, root2));
    }

    public static TreeNode buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("-1")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            if (!values[i].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;

            if (i >= values.length) break;

            if (!values[i].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/*
https://leetcode.com/problems/leaf-similar-trees

Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
Two binary trees are considered leaf-similar if their leaf value sequence is the same.
Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Binary Tree / DFS / Traversal

Approach:
• The idea is to compare the leaf node sequences of both trees.
• Use Depth-First Search (DFS) to collect leaf nodes:
  - Traverse the tree in left-to-right order.
  - If a node has no left and right child, it is a leaf → add its value to a list.
• Perform this traversal for both trees and store their leaf sequences.
• Compare the two lists:
  - If they are equal → trees are leaf-similar.
  - Otherwise → not leaf-similar.

Time Complexity:
• O(n + m)
• n = number of nodes in tree1, m = number of nodes in tree2.
• Each node is visited once.

Space Complexity:
• O(n + m)
• Lists store leaf nodes.
• Recursion stack also contributes (up to height of trees).
*/
class Sol34{
    public boolean leafSimilar(TreeNode root1, TreeNode root2){
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    public void getLeaves(TreeNode node, List<Integer> leaves){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            leaves.add(node.val);
            return;
        }
        getLeaves(node.left, leaves);
        getLeaves(node.right, leaves);
    }
}