class LRUCache {

    class Node{

        int key,value;
        Node prev,next;

        Node(int key,int value){
            this.key=key;
            this.value=value;
        }

    }

    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    int limit=0;
    HashMap<Integer,Node> map=new HashMap<>();

    public LRUCache(int capacity) {
        head.next=tail;
        tail.prev=head;

        limit=capacity;
    }

    public void addNode(Node node){

        node.next=head.next;
        node.prev=head;

        head.next.prev=node;
        head.next=node;

    }

    public void deleteNode(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.next;

        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }
    
    public int get(int key) {

        if(!map.containsKey(key)){
            return -1;
        }

            Node newNode=map.get(key);
            deleteNode(newNode);
            addNode(newNode);
            return newNode.value;
        
        
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){

            Node newNode=map.get(key);
            deleteNode(newNode);
            map.remove(key);
        }

        if(map.size()==limit){
            Node lru=tail.prev;
            deleteNode(lru);
            map.remove(lru.key);
        }

        Node newNode=new Node(key,value);
        addNode(newNode);
        map.put(key,newNode);
    }
}
