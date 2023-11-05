class Solution {

    public int solve(int[][] dp, int sum, int[] coins, int i, int n){

        if(sum == 0) return 1;
        if(sum<0 || i>=n) return 0;

        if(dp[i][sum] !=-1) return dp[i][sum];

        return dp[i][sum] = solve(dp, sum-coins[i], coins, i, n) + solve(dp, sum, coins, i+1, n);
    }

    public int change(int sum, int[] coins) {

        int[][] dp = new int[coins.length+1][sum+1];

        for(int[] x: dp) Arrays.fill(x, -1);

        return solve(dp, sum, coins, 0, coins.length);

        
        
    }
}
