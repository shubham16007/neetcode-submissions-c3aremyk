class LRUCache {

    class Node{

        int key,value;
        Node prev,next;

        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    HashMap<Integer,Node> map;
    int limit=0;

    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);

    public LRUCache(int capacity) {
        limit=capacity;
        map=new HashMap<>();

        head.next=tail;
        tail.prev=head;

    }

    public void addNode(Node node){

        node.next=head.next;
        node.prev=head;

        head.next.prev=node;
        head.next=node;

    }

    public void deleteNode(Node node){

        Node prevHead=node.prev;
        Node nextHead=node.next;

        prevHead.next=nextHead;
        nextHead.prev=prevHead;

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
           Node node=map.get(key); 
           map.remove(key);
           deleteNode(node);
        }

        if(map.size()==limit){

            Node lru=tail.prev;
            deleteNode(lru);
            map.remove(lru.key);
        }

        Node node=new Node(key,value);
        addNode(node);
        map.put(key,node);
        
    }
}
