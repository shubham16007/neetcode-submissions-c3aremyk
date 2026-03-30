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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb=new StringBuilder();
        preorder(root,sb);
        return sb.toString();
        
    }

    public void preorder(TreeNode node,StringBuilder sb){

        if(node==null){
            sb.append("null,");
            return;
        }

        sb.append(node.val).append(",");
        preorder(node.left,sb);
        preorder(node.right,sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] values=data.split(",");

        Queue<String> queue=new LinkedList<>(Arrays.asList(values));
        return buildTree(queue);
        
    }


    public TreeNode buildTree(Queue<String> queue){

        String val=queue.poll();

        if(val.equals("null")) return null;

        TreeNode node =new TreeNode(Integer.parseInt(val));
        node.left=buildTree(queue);
        node.right=buildTree(queue);

        return node;
    }
}
