class SortByStart implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        return a[0] - b[0]; 
    }
}

class SortByEnd implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        return a[1] - b[1]; 
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length < 2){
            return intervals.length;
        }
        int i = 0; 
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new SortByEnd()); 
        Arrays.sort(intervals, new SortByStart()); 
        while (i < intervals.length){
            if(pq.size() == 0 || intervals[i][0] < pq.peek()[1]){
                pq.add(intervals[i]); 
            } else {
                pq.poll(); 
                pq.add(intervals[i]); 
            }
            // if(intervals[j][0] > intervals[i][1])
            i++; 
        }
        return pq.size(); 
    }
}

// 与meeting room1不同，光靠比较sort后相邻的end/start已经不够用。

// 需要sort+queue
// 或者直接priority queue

// 关键：
// 新meeting start与目前[最先结束的meeting（而不是相邻上一个）] end比较，
// 被比较者的选取与开始顺序无关，只与结束end先后有关。

// start>end, do nothing; 
// start<=end, room++, 