class Solution {

    public int solve(int[] dp, int[] nums, int i){

        if(i>=nums.length) return 0;
        if(dp[i] != -1) return dp[i];

        return dp[i] = Math.max(nums[i]+solve(dp, nums, i+2), solve(dp, nums, i+1));

    }

    public int rob(int[] nums) {

        int[] dp = new int[nums.length];
        // Arrays.fill(dp, -1);

        // return solve(dp, nums, 0);
        int prev=0, curr=0;
        if(nums.length == 1) return nums[0];
        if(nums.length>=1) prev = nums[0];
        if(nums.length>=2) curr = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++){
            int temp = curr;
            curr = Math.max(nums[i]+prev, curr);
            prev = temp;
        }

        return curr;
        
    }
}
