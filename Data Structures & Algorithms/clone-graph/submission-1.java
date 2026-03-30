/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    HashMap<Node,Node> map=new HashMap<>();
    public Node cloneGraph(Node node) {
        

        if(node==null){
           return node;
        }

        if(node.neighbors.size()==0){
             return new Node(node.val,new ArrayList<>());
        }

        return dfs(node,map);
    }

    public Node dfs(Node node,HashMap<Node,Node> map){

        Node clone=new Node(node.val);
        map.put(node,clone);

        for(Node it:node.neighbors){

            if(map.containsKey(it)){

                clone.neighbors.add(map.get(it));
            }else{
                clone.neighbors.add(dfs(it,map));
            }
        }

        return clone;

    }
}