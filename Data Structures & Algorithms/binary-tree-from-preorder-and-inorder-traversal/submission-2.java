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

    HashMap<Integer,Integer> inorderIndexMap=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++){
            inorderIndexMap.put(inorder[i],i);
        }

        return buildTree(preorder,inorderIndexMap,0,0,inorder.length-1);
    }


    public TreeNode buildTree(int[] preorder,HashMap<Integer,Integer> inorderIndexMap,int startIndex,int left,int right){

        TreeNode node=new TreeNode(preorder[startIndex]);

        int mid=inorderIndexMap.get(node.val);

        if(left<mid){

            node.left=buildTree(preorder,inorderIndexMap,startIndex+1,left,mid-1);
        }

        if(right>mid){

            node.right=buildTree(preorder,inorderIndexMap,startIndex-left+mid+1,mid+1,right);
        }
        
        return node;
    }
}
