class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int gm = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1) {
                count++;
                gm = Math.max(gm, count);
            } else {
                count = 0;
            }
        }

        return gm;
    }
}