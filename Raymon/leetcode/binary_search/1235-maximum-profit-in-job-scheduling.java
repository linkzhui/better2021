class Solution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int size = startTime.length;
        PriorityQueue<Data> pq = new PriorityQueue<>((a,b) -> (a.endTime - b.endTime));
        for (int i = 0; i < size; i++) {
            pq.add(new Data(startTime[i], endTime[i], profit[i]));
        }
        int max = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(0,0);
        while (!pq.isEmpty()) {
            Data job = pq.poll();
            Integer currentProfit = treeMap.floorEntry(job.startTime).getValue() + job.maxProfit;
            if (currentProfit > treeMap.lastEntry().getValue()) {
                treeMap.put(job.endTime, currentProfit);
            }
        }
        return treeMap.lastEntry().getValue();
    }



    class Data {
        int startTime;
        int endTime;
        int maxProfit;

        public Data(int startTime, int endTime, int maxProfit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.maxProfit = maxProfit;
        }
    }

}
