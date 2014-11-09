import java.util.*;

/**
 * Created by Imran on 11/9/2014.
 *
 * Given a list of intervals, merge all overlapping intervals and output only disjoint intervals.
 */
public class MergeIntervals {

    public Interval[] mergeOverlappingIntervals(Interval[] intervals) {
        Arrays.sort(intervals);
        Stack<Interval> mergedIntervals = new Stack<Interval>();
        mergedIntervals.add(intervals[0]);
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i].overlaps(mergedIntervals.peek())) {
                Interval tos = mergedIntervals.pop();
                tos.setEnd(Math.max(intervals[i].getEnd(), tos.getEnd()));
                mergedIntervals.push(tos);
            } else {
                mergedIntervals.push(intervals[i]);
            }
        }
        // An iterator gives elements in list order, but not the order of pop.
        // Whereas popping items until empty gives the same elements in reverse order.
        Iterator<Interval> iterator = mergedIntervals.listIterator();
        List<Interval> result = new ArrayList<Interval>();
        while(iterator.hasNext()) {
           result.add(iterator.next());
        }

        return result.toArray(new Interval[0]);
    }

}
