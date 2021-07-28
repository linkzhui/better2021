class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int temMax = 1;
            for (int j = 1; j < i; j++) {
                temMax = Math.max(Math.max(dp[j], j) * (i - j), temMax);
            }
            dp[i] = temMax;
        }
        return dp[n];
    }
}
