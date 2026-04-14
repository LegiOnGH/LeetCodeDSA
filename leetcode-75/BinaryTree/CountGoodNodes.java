package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountGoodNodes{
       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter nodes in level order (-1 for null):");
        String[] input = sc.nextLine().split(" ");
        sc.close();
        TreeNode root = buildTree(input);

        Sol35 sol = new Sol35();
        System.out.println("No. of Good Nodes: " + sol.goodNodes(root));
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
https://leetcode.com/problems/count-good-nodes-in-binary-tree

Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
Return the number of good nodes in the binary tree.

problem type
approach
time
space
*/
class Sol35{
    public int goodNodes(TreeNode root){
        return dfs(root, root.val);
    }
    public int dfs(TreeNode node, int maxVal){
        if(node == null){
            return 0;
        }

        int count = 0;

        if(node.val >= maxVal){
            count = 1;
        }

        maxVal = Math.max(maxVal, node.val);

        count += dfs(node.left, maxVal);
        count += dfs(node.right, maxVal);

        return count;
    }
}
