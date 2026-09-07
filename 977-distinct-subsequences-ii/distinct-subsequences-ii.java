class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;
        long total = 0;
        long[] end = new long[26];

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            long newCount = (total + 1) % MOD;
            total = (total + newCount - end[idx] + MOD) % MOD;
            end[idx] = newCount;
        }

        return (int) total;
    }
}