class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int large = nums[nums.length-1];
        int small = nums[0];
        int ans = 1;
        for(int i = 2; i <= large; i++){
            if(large % i == 0 && small % i == 0)  ans = Math.max(ans, i);
        }

        return ans;
    }
}