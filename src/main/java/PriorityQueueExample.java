import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Imran on 9/17/2014.
 *
 * By default priority queue is min-heap. If comparator is not given, it uses natural order.
 * PriorityQueue is not synchronized. PriorityBlockingQueue is synchronized.
 *
 * add(), poll()
 * offer(e), remove(e)
 */
public class PriorityQueueExample {

    public static void main(String[] args) {
        Comparator<Integer> reverseOrder = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, reverseOrder);
        maxHeap.addAll(Arrays.asList(5, 6, 1, 2, 4, 9));
        int size = maxHeap.size();
        for(int i=0; i< size; i++) {
            // Poll is equivalent to dequeue, remove(obj) method actually removes the specified element from queue.
            System.out.println(maxHeap.poll());
            maxHeap.remove(2);
        }
    }
}
