class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
         int n = words.length;
         int[] dp = new int[n];
         int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxl = 1, lasti =0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(groups[i] != groups[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }

            if(dp[i] > maxl){
                maxl = dp[i];
                lasti = i;
            }
        }

        List<String> ans = new ArrayList<>();
        while(lasti != -1){
            ans.add(words[lasti]);
            lasti = parent[lasti];
        }

        Collections.reverse(ans);
        return ans;
    }
}