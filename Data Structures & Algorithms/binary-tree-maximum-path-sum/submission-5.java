/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        if(root==null) return 0;

        inorder(root);

        return maxSum;       
    }

    public int inorder(TreeNode node){

        if(node==null) return 0;

        int left=Math.max(inorder(node.left),0);

        int right=Math.max(inorder(node.right),0);

        int newPrice=node.val+left+right;

        maxSum=Math.max(maxSum,newPrice);

        return node.val+Math.max(left,right);

    }
}
