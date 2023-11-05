class Solution {

    public int solve(int[][] dp, int[] prices, int buy, int ind){

        if(ind>=prices.length) return 0;

        if(dp[ind][buy] != -1) return dp[ind][buy];

        if(buy == 1){
            return dp[ind][buy] = Math.max(-prices[ind] + solve(dp, prices, 0, ind+1), solve(dp, prices, 1, ind+1));
        }

        else{
            return dp[ind][buy] =  Math.max(prices[ind] + solve(dp, prices, 1, ind+2), solve(dp, prices, 0, ind+1));
        }
    }

    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][2];

        for(int[] x:dp) Arrays.fill(x, -1);
        
        return solve(dp, prices, 1, 0);
    }
}
