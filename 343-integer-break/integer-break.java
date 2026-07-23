class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i/2; j++){
                int max1 = Math.max(j, dp[j]);
                int max2 = Math.max(i - j, dp[i - j]);
                dp[i] = Math.max(dp[i], max1*max2);
            }
        }
        return dp[n];
    }
}