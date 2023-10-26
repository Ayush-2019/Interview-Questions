class Solution {

    public int solve(int[] dp, int[] cost, int i, int c){

        if(i==cost.length-1) return cost[i];
        if(i==cost.length-2) return cost[i];
        

        if(dp[i] != -1) return dp[i];

        return dp[i] = cost[i] + Math.min(solve(dp, cost, i+1, c+cost[i]), solve(dp, cost, i+2, c+cost[i]));
    }

    public int minCostClimbingStairs(int[] cost) {

        int[] dp= new int[cost.length];
        Arrays.fill(dp, -1);
        
        int first = solve(dp, cost, 0, 0);
        int second = solve(dp, cost, 1, 0);
        return Math.min(first, second);

        // space op.
        // int prev = cost[0];
        // int curr = cost[1];

        // for(int i=2;i<cost.length;i++){
        //     int temp = curr;
        //     curr = cost[i] + Math.min(prev, curr);
        //     prev = temp;
        // }

        // return Math.min(prev, curr);
    }
}
