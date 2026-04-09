package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxDepth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter nodes in level order (-1 for null):");
        String[] input = sc.nextLine().split(" ");
        sc.close();
        TreeNode root = buildTree(input);

        Sol33 sol = new Sol33();
        int depth = sol.maxDepth(root);
        System.out.println("Maximum Depth: " + depth);
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
    TreeNode() {};
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
https://leetcode.com/problems/maximum-depth-of-binary-tree

Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Binary Tree / Recursion / Depth-First Search (DFS)

Approach:
• Use recursion to compute the depth of the tree.
• Base case:
  - If the node is null, return 0.
• Recursively calculate:
  - leftDepth = depth of left subtree
  - rightDepth = depth of right subtree
• The depth of the current node is:
      max(leftDepth, rightDepth) + 1
• Return the computed depth.

Time Complexity:
• O(n)
• Each node is visited exactly once.

Space Complexity:
• O(h)
• h = height of the tree (due to recursion stack).
• Worst case (skewed tree): O(n)
• Best case (balanced tree): O(log n)
*/
class Sol33{
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
