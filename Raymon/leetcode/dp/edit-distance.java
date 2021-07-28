class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //dp[i][j] represents what is minimum number of actions needed to transform the first i letter of word1 to first j letter of word2
        //smaller problem:
        //dp[i-1][j], dp[i-1][j-1], dp[i][j-1]
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {

                if (word1.charAt(i) != word2.charAt(j)) {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j], dp[i+1][j]), dp[i][j+1]) +1;
                } else {
                    dp[i+1][j+1] = dp[i][j];
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
