class Solution {

    public int solve(int[] dp, int[] nums, int i, int n){

        if(i>=n) return 0;
        if(dp[i] != -1) return dp[i];

        return dp[i] = Math.max(nums[i]+solve(dp, nums, i+2, n), solve(dp, nums, i+1, n));

    }

    public int rob(int[] nums) {

        if(nums.length == 1) return  nums[0];

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        int f = solve(dp, nums, 0, nums.length-1);
        Arrays.fill(dp, -1);
        int s = solve(dp, nums, 1, nums.length);
        return Math.max(f, s);
        
    }
}
