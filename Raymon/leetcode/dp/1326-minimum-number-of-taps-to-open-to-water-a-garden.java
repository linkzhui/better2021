class Solution {
    public int minTaps(int n, int[] ranges) {
        //result represent the point 0 to n
        int[] result = new int[n + 1];
        Arrays.fill(result, n + 1);
        result[0] = 0;
        for (int i = 0; i < ranges.length; i++) {
            int start = i - ranges[i];
            int end = i + ranges[i];
            //point 0 represent range (-1, -1)
            for (int j = Math.max(1, start + 1); j < Math.min(end + 1, n + 1); j++) {
                result[j] = Math.min(result[j], result[Math.max(0, start)] + 1);
            }
        }
        return result[n] == n+1? -1 : result[n];
    }
}
