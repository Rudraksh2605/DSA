class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+2][n+2];

        for(int len = 2; len <= n; len++){
            for(int start = 1; start + len - 1 <= n; start++){
                int end = start + len - 1;
                dp[start][end] = Integer.MAX_VALUE;

                for(int guess = start; guess <= end; guess++){
                    int left = (guess > start) ? dp[start][guess-1] : 0;
                    int right = (guess < end) ? dp[guess+1][end] : 0;
                    int cost = guess + Math.max(left, right);
                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }
        return dp[1][n];
    }
}