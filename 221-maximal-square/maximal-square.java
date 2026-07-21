class Solution {
    public int maximalSquare(char[][] m) {
        if(m == null || m.length == 0 || m[0].length == 0) return 0;
        int r = m.length;
        int c = m[0].length;
        int[][] dp =  new int[r+1][c+1];
        int maxs = 0;

        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                if(m[i-1][j-1] == '1'){
                    int minadj = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                    dp[i][j] = minadj + 1;
                    maxs = Math.max(maxs, dp[i][j]);
                }
            }
        }
        return maxs*maxs;
    }
}