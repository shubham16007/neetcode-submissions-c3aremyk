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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        Stack<TreeNode> leftTree=new Stack<>();
        Stack<TreeNode> rightTree=new Stack<>();

        leftTree.push(p);
        rightTree.push(q);


        while(!leftTree.isEmpty() && !rightTree.isEmpty()){

            TreeNode left =leftTree.pop();
            TreeNode right=rightTree.pop();

            if(left==null && right==null) continue;

            if(left==null || right==null || left.val!=right.val){
                return false;
            }

            leftTree.push(left.left);
            leftTree.push(left.right);
            rightTree.push(right.left);
            rightTree.push(right.right);


        }


            return true;
    }
}
