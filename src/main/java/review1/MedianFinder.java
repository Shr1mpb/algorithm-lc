package review1;

import java.util.PriorityQueue;

/**
 * 数据流的中位数
 * // TODO 大小顶堆
 */
class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>(); // 小顶堆，存大的那一半（那么堆顶元素就是大半里面最小的那个，即最接近中心的）
        maxHeap = new PriorityQueue<Integer>((x, y) -> y - x);// 大顶堆，存小的那一半（那么堆顶元素就是小半里面最大的那个，即最接近中心的）
    }

    public void addNum(int num) {
        if (minHeap.isEmpty() || num > minHeap.peek()) {// 如果新数字大于小顶堆的堆顶元素（即当前"较大的一半"中的最小值），说明这个数字确实属于较大的那一半，所以放入小顶堆。
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        // 这里确保minHeap 和 maxHeap要么一样多 要么是minHeap多一个
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return minHeap.peek();
        }
    }
}
