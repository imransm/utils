import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import java.util.Arrays;

/**
 * Created by moshaik on 6/5/2015.
 *
 * Given a log file with the following details, compute the maximum memory at any point in time.
 *
 * #start_timestamp, #end_timestamp, #pid, #memory (MB)
 *   3             ,   7           ,  1,     550
 *   5             ,   9           ,  2,     250
 *   ..........
 *
 *  Google
 *
 */
public class MaxMemory {

    int computeMaxMemory(LogEntry[] entries) {
        StartEntry[] starts = getStartArray(entries);
        EndEntry[] ends = getEndArray(entries);
        int maxMemory = 0;
        int totalMemory = maxMemory;
        int start = starts[0].getStart();
        int end = starts[starts.length -1].getStart();
        int sIndex = 0;
        int eIndex = 0;
        for(int i=start; i<= end; i++) {
            // Pick up all processes that start at the time-line i
            while(sIndex < starts.length && starts[sIndex].getStart() <= i) {
                totalMemory = totalMemory + starts[sIndex].getMemory();
                sIndex++;
            }
            // Remove all processes that end at time-line i
            while(eIndex < ends.length && ends[eIndex].getEnd() <= i) {
               totalMemory =  totalMemory - ends[eIndex].getMemory();
                eIndex++;
            }
            if(totalMemory > maxMemory) {
                maxMemory = totalMemory;
            }
        }
        return maxMemory;
    }

    private StartEntry[] getStartArray(LogEntry[] entries) {
        StartEntry[] startEntries = new StartEntry[entries.length];
        for(int i=0; i<entries.length; i++) {
            startEntries[i] = new StartEntry(entries[i].getStart(), entries[i].getPid(), entries[i].getMemory());
        }
        Arrays.sort(startEntries);
        return startEntries;
    }

    private EndEntry[] getEndArray(LogEntry[] entries) {
        EndEntry[] endEntries = new EndEntry[entries.length];
        for(int i=0; i<entries.length; i++) {
            endEntries[i] = new EndEntry(entries[i].getEnd(), entries[i].getPid(), entries[i].getMemory());
        }
        Arrays.sort(endEntries);
        return endEntries;
    }
}

class StartEntry implements Comparable<StartEntry>{
    private final int memory;
    private int start;
    private int pid;
    public StartEntry(int start, int pid, int memory) {
        this.start = start;
        this.pid = pid;
        this.memory = memory;
    }

    public int compareTo(StartEntry o) {
        return this.start - o.start;
    }

    public int getMemory() {
        return memory;
    }

    public int getPid() {
        return pid;
    }

    public int getStart() {
        return start;
    }

    @Override
    public String toString() {
        return "StartEntry{" +
                "memory=" + memory +
                ", start=" + start +
                '}';
    }
}

class EndEntry implements Comparable<EndEntry>{
    private final int memory;
    private int end;
    private int pid;
    public EndEntry(int end, int pid, int memory) {
        this.end = end;
        this.pid = pid;
        this.memory = memory;
    }

    public int compareTo(EndEntry o) {
        return this.end - o.end;
    }

    public int getMemory() {
        return memory;
    }

    public int getEnd() {
        return end;
    }

    public int getPid() {
        return pid;
    }

    @Override
    public String toString() {
        return "EndEntry{" +
                "memory=" + memory +
                ", end=" + end +
                '}';
    }
}


class LogEntry {
    private int start;
    private int end;
    private int pid;
    private int memory;

    public LogEntry(int start, int end, int pid, int memory) {
        this.start = start;
        this.end = end;
        this.pid = pid;
        this.memory = memory;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getPid() {
        return pid;
    }

    public int getMemory() {
        return memory;
    }
}
