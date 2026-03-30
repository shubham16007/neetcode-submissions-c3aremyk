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

        return dfs(preorder,inorderIndexMap,0,0,inorder.length-1);
    }


    public TreeNode dfs(int [] preorder, HashMap<Integer,Integer> inorderIndexMap,int inorderIndex,int left,int right){

        TreeNode node=new TreeNode(preorder[inorderIndex]);

        int mid=inorderIndexMap.get(node.val);

        if(mid>left){

            node.left=dfs(preorder,inorderIndexMap,inorderIndex+1,left,mid-1);
        }

        if(mid<right){
            node.right=dfs(preorder,inorderIndexMap,inorderIndex-left+mid+1,mid+1,right);
        }

        return node;

    }
}
