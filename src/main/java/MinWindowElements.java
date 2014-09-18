import java.util.*;

/**
 * Created by Imran on 9/17/2014.
 *
 * Given a larger integer buffer/array (say size, x), now given a window size (say, n) and a number (say, k).
 * Windows starts from the 1st element and keeps shifting right by one element.
 * The objective is to find the minimum k numbers present in each window.
 *
 * Using priority queue will solve the problem, but priority queue removal is linear in time.
 * It would be done for every window change. i.e O(n) operation.
 *
 */
public class MinWindowElements {

    public void printMinK(int[] a, int n, int k) {
        PriorityQueue<Integer> minK = constructMinKSet(a, n, k);
        PriorityQueue<Integer> remainingAll = constructMaxNMinusKSet(a, n, minK);
        printInputArray(a);
        printMinKElements(minK, n-1, n);


        for(int i=n; i< a.length; i++) {
            // Now window moves further.
            //delete last element irrespective from tree if it exists in it.
            // After deletion adjust the sets with incoming element.

            // try minK first, then max
            minK.remove(a[i-n]);
            boolean noElementDeletedFromMinK = (minK.size() == k);
            boolean elementDeletedFromMax = false;
            if(noElementDeletedFromMinK) {
                remainingAll.remove(a[i - n]);
                elementDeletedFromMax = true;
            }

            // Incoming element is less than min of remainingAll
            if(a[i] <= remainingAll.peek()) {

                // Incoming element is further less than last element of minK. So incoming element goes to minK
                if(a[i] <= minK.peek()) {
                   if (elementDeletedFromMax) {
                       Integer elementPopped = minK.poll();
                       remainingAll.add(elementPopped);
                   }
                   minK.add(a[i]);
               }
               // a[i] lies in the middle of two sets, then if minK set size is reduced, add to it. Else add to remainingAll
               // minK.last() < a[i] < remainingAll.first()
               else {
                   if(elementDeletedFromMax) {
                       remainingAll.add(a[i]);
                   } else {
                       minK.add(a[i]);
                   }
               }
            }
            // new element belongs to remainingAll
            else {
                if(elementDeletedFromMax) {
                    remainingAll.add(a[i]);
                } else {
                    Integer poppedElement = remainingAll.poll();
                    remainingAll.add(a[i]);
                    minK.add(poppedElement);
                }
            }

            printMinKElements(minK, i, n);
        }
    }

    private void printInputArray(int[] a) {
        for(int i: a) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    private void printMinKElements(PriorityQueue<Integer> minK, int windowEnd, int n) {
        System.out.println("Window [" + (windowEnd - n + 1) + ", " + windowEnd + "]");
        Iterator<Integer> iterator = minK.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();
    }

    private PriorityQueue<Integer> constructMaxNMinusKSet(int[] a, int n, PriorityQueue<Integer> minK) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i =0; i<n; i++) {
            if(!minK.contains(a[i])) {
                minHeap.add(a[i]);
            }
        }
        return minHeap;
    }

    private PriorityQueue<Integer> constructMinKSet(int[] a, int n, int k) {
        Comparator<Integer> reverseOrderComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, reverseOrderComparator);
        for(int i=0; i<k; i++)
            maxHeap.add(a[i]);
        for(int i =k; i<n; i++) {
            if(a[i] < maxHeap.peek()) {
                // removes last element, equivalent to teeSet.remove(treeSet.last());
                maxHeap.poll();
                maxHeap.add(a[i]);
            }
        }
        return maxHeap;
    }
}
