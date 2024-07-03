class MedianFinder {

    private PriorityQueue<Integer> minHeap, maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<Integer>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return ((double) (minHeap.peek() + maxHeap.peek())) / 2.0;
        } else {
            return (double) maxHeap.peek();
        }
    }
}