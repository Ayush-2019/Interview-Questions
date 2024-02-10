class MedianFinder {

    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;


    public MedianFinder() {

        this.max = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));
        this.min = new PriorityQueue<Integer>();
        
    }
    
    public void addNum(int num) {

        max.add(num);
        min.add(max.poll());

        if(min.size()>max.size()) max.add(min.poll());
        
    }
    
    public double findMedian() {

        if(max.size()>min.size()) return max.peek();

        return (double)(min.peek()+max.peek())/2;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
