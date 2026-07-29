class Solution {
    public long minCost(int[] nums, int x) {
        long res = Long.MAX_VALUE;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int k = 0; k < n; k++) {
            long sum = (long) k * x;
            for (int i = 0; i < n; i++) {
                dp[i] = Math.min(dp[i], nums[(i + k) % n]);
                sum += dp[i];
            }
            res = Math.min(res, sum);
        }
        
        return res;
    }
}