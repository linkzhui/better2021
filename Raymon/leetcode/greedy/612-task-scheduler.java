package greedy;

class Solution {
    //use round robin to manage the task scheduler
    //therefore the max idle time should be requency of the most frequent task * (n-1)
    //use int[] freq to get all the tasks frequency and sort the freq array
    //So that we can fill in the task scheduler with next most frequent task
    //then we minus the idle time from those task frequency
    //if current task's frequency equal to max freqnecy, then idle -= freq[i] - 1;
    //then total step = total tasks + idle time
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks) {
            freq[task-'A']++;
        }
        Arrays.sort(freq);
        int f_max = freq[25];
        int idle_time = (f_max - 1) * n;
        for (int i = 24; i >= 0 && idle_time > 0; --i) {
            if (freq[i] == f_max) {
                idle_time -= freq[i] -1;
            } else {
                idle_time -= freq[i];
            }
        }
        return Math.max(0, idle_time) + tasks.length;

    }

    private class Helper {
        char task;
        int count;
        public Helper(char task, int count) {
            this.task = task;
            this.count = count;
        }
    }
}
