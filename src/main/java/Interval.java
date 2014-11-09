import java.util.Comparator;

/**
* Created by Imran on 11/9/2014.
*/
public class Interval implements Comparable<Interval> {
    private int start;
    private int end;
    public Interval(int start, int end) {
        this.setStart(start);
        this.setEnd(end);
    }
    public boolean overlaps(Interval i) {
        // starts after current or ends before current for non overlapping.
        return !(this.getEnd() < i.getStart() || this.getStart() > i.getEnd());
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interval interval = (Interval) o;

        if (end != interval.end) return false;
        if (start != interval.start) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }

    @Override
    public int compareTo(Interval o) {
        return start - o.start;
    }
}
