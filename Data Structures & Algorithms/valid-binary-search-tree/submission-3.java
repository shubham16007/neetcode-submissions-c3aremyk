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

    List<Integer> list=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {

        if(root==null) return false;


        helper(root);

        int prev=list.get(0);

        for(int i=1;i<list.size();i++){

            if(list.get(i)<=prev){
                return false;
            }

            prev=list.get(i);
        }

        return true;
        
    }

    public void helper(TreeNode node){

        if(node==null) return;

        helper(node.left);
        list.add(node.val);
        helper(node.right);

    }
}
