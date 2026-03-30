class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());

        for(int n:stones){
            queue.offer(n);
        }


        while(queue.size()>1){
            int y=queue.poll();
            int x=queue.poll();

            if(y!=x){
                queue.offer(y-x);
            }

        }

        return queue.isEmpty()?0:queue.peek();
        
    }
}
