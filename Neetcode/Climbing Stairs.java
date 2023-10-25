class Solution {

    public int solve(int dp[], int n, int i){

        if(i == n) return 1;
        if(i>n) return 0;

        if(dp[i] != -1) return dp[i];


        return dp[i] = solve(dp, n, i+1) + solve(dp, n, i+2);
    }

    public int climbStairs(int n) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        solve(dp,n,0);

        return dp[0];

        
        

    }
    // space optimization approach
    public int climbStairs(int n) {
        // int dp[] = new int[n];
        // Arrays.fill(dp, -1);
        // solve(dp,n,0);

        // return dp[0];
        if(n==1) return 1;
        if(n==2) return 2;
        int prev = 1;
        int curr = 2;

        for(int i=2;i<n;i++){
            int temp = curr;
            curr = prev+curr;
            prev = temp;
        }

        return curr;

    }
}
