package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class lc_759_employee_free_time {
}


// Definition for an greedy.Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};


class greedy.two_pointer.two_pointer.two_pointer.two_pointer.two_pointer.Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

    //首先创建一个ascending priority queue,然后根据schedule的start time来排序
    //再iterate整个priority queue
    // prev_end: 之前遍历过的所有schedule的最迟end time
    //每次从pq里面poll出来一个schedule，我们就比较这个schedule的start time和prev_end来比较
    //如果start time 大于prev_end,我们就找到了一个free time， 更新prev_end
    //如果start time 小于prev_end，当前的schedule和之前的有重叠，更新prev_end

    //Time complexity: O(nlogn)
    //Space complexity: O(n)    n: total number of intervals
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b)-> (a.start - b.start));
        for (List<Interval> intervals : schedule) {
            pq.addAll(intervals);
        }
        List<Interval> result = new ArrayList<>();
        Integer prev_end = null;
        while(!pq.isEmpty()) {
            Interval cur = pq.poll();
            if (prev_end == null) {
                prev_end = cur.end;
            } else {
                if (prev_end < cur.start) {
                    //free time
                    result.add(new Interval(prev_end, cur.start));
                }
                prev_end = Math.max(prev_end, cur.end);

            }
        }
        return result;
    }

}