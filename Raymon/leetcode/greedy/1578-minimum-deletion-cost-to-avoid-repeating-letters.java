class Solution {
    public int minCost(String s, int[] cost) {
        if (s.length() < 2) {
            return 0;
        }
        int prev = 0;
        int totalCost = 0;
        char[] array = s.toCharArray();
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[prev]) {
                prev = i;
                continue;
            } else {
                if (cost[prev] > cost[i]) {
                    totalCost += cost[i];
                } else {
                    totalCost += cost[prev];
                    prev = i;
                }
            }
        }
        return totalCost;
    }
}
