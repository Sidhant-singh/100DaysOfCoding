class MedianFinder {
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minheap = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if(maxheap.size()==0) maxheap.add(num);
        else {
            if(num<maxheap.peek()) maxheap.add(num);
            else minheap.add(num);
        }

//        balancing the heaps
        if(maxheap.size()==minheap.size()+2){
            int top = maxheap.remove();
            minheap.add(top);
        }
        if(minheap.size()==maxheap.size()+2){
            int top = minheap.remove();
            maxheap.add(top);
        }
    }

    public double findMedian() {
        if(minheap.size()==maxheap.size()){
            return (maxheap.peek()+minheap.peek())/2.0;
        }
        else if(maxheap.size()>minheap.size())
            return maxheap.peek();
        else return minheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */