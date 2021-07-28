class Solution {
    public int maximalSquare(char[][] matrix) {
        int[] dp = new int[matrix[0].length + 1];
        int max = 0;
        int prev = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = dp[j+1];
                if(matrix[i][j] == '1') {
                    dp[j+1] = Math.min(dp[j], Math.min(dp[j+1], prev)) + 1;
                    max = Math.max(max, dp[j+1]);
                } else {
                    dp[j+1] = 0;
                }
                prev = temp;
            }
        }
        return max * max;
    }
}
