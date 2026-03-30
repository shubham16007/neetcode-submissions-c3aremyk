class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        
        min=new PriorityQueue<>();
        max=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());

        if(min.size()>max.size()){
            max.add(min.poll());
        }

    }
    
    public double findMedian() {

        if(max.size()>min.size()){
            return max.peek();
        }

        return (double) (max.peek()+min.peek())/2.0;
        
    }
}
