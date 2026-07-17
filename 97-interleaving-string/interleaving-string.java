class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        
        // Quick fail: if lengths don't add up, it's impossible
        if (m + n != s3.length()) {
            return false;
        }
        
        // Step 1: Create the DP table (spreadsheet)
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Step 2: Initialize base cases and edges
        dp[0][0] = true;
        
        // Fill first column (Using only s1)
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        // Fill first row (Using only s2)
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // Step 3 & 4: Execute state transition via traversal
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                
                // Which character in s3 are we trying to match?
                int k = i + j - 1; 
                
                // Look above (take from s1)
                boolean takeS1 = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k);
                
                // Look left (take from s2)
                boolean takeS2 = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k);
                
                // If either path works, this cell is valid
                dp[i][j] = takeS1 || takeS2;
            }
        }
        
        // The final answer is always the bottom-right cell
        return dp[m][n];
    }
}