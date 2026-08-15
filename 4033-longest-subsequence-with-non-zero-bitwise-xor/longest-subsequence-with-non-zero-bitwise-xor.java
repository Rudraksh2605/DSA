class Solution {
    public int longestSubsequence(int[] nums) {
        int t = 0;
        for(int n: nums){
            t ^= n;
            
        }

        if(t != 0){
            return nums.length;
        }

        for(int n : nums){
            if(n != 0){
                return nums.length-1;
            }
        }

        return 0;
    }
}