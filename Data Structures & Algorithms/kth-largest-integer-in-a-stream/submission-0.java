class KthLargest {

    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        queue=new PriorityQueue<>();
        this.k=k;

        for(int n:nums){
            add(n);
        }
    }
    
    public int add(int val) {
        
        queue.offer(val);

        if(queue.size()>k){
            queue.poll();
        }

        return queue.peek();

    }
}
