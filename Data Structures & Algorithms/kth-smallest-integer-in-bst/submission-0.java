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
    int pos=0;
    public int kthSmallest(TreeNode root, int k) {

        if(root==null) return 0; 
        
        TreeNode node=inorder(root,k);
        if(node==null) return -1;

        return node.val;
    }

    public TreeNode inorder(TreeNode node, int k){

        if(node==null) return null;

        TreeNode left=inorder(node.left,k);
        if(left!=null){
           return left;
        }

        pos++;

        if(pos==k){
            return node;
        }


        TreeNode right=inorder(node.right,k);
        if(right!=null){
           return right;
        }

        return null;

    }

}
