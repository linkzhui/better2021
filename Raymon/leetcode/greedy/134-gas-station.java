class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int curTank = 0;
        int startPoint = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalTank += diff;
            curTank += diff;
            if (curTank < 0) {
                //current startPoint cannot reach this point
                //set current index as start point
                curTank = 0;
                startPoint = i+1;
            }
        }
        return totalTank >= 0? startPoint : -1;
    }
}
