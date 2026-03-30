class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer>max;
    public MedianFinder() {

        max=new PriorityQueue<>(Collections.reverseOrder());
        min=new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {

        max.offer(num);

        min.offer(max.poll());

        if(min.size()>max.size()){
            max.offer(min.poll());
        }
        
    }
    
    public double findMedian() {
        

        if(max.size()>min.size()){
            return   max.peek();
        }


        return  (double) (max.peek()+min.peek())/2.0;
    }
}
