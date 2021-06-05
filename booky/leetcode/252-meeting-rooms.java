class SortByStart implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        return a[0] - b[0];
    }
}

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length < 2){
            return true; 
        }
        
        Arrays.sort(intervals, new SortByStart()); 
        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i][1] > intervals[i+1][0]){
                return false; 
            }
        }
        return true;
    }
}

// 1. sort by arr[0]
// 2. 挨个比较相邻两个int[]元素是否overlap，必须严格不重合，前一个end < 后一个start