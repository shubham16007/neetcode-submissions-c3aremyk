class Solution {
    public int lastStoneWeight(int[] stones) {

        if(stones.length<1) return 0;

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int n:stones){
            pq.offer(n);
        }


        while(pq.size()>1){

            int y=pq.poll();
            int x=pq.poll();

            if(y>x){
                pq.offer(y-x);
            }

        }

        return pq.isEmpty()?0:pq.peek();
        
    }
}
