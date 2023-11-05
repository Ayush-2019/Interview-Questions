class Solution {

    public int solve(int[][] dp, int i, int j, int m, int n){

        if(i == m-1 && j == n-1) return 1;
        if(i >= m || j >= n) return 0;

        if(dp[i][j] != -1 ) return dp[i][j];

        int down = 0, right = 0;

        if(i+1<m) down = solve(dp, i+1, j, m, n);
        if(j+1<n) right = solve(dp, i, j+1, m, n);

        return dp[i][j] = down + right;
    }

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for(int[] x : dp) Arrays.fill(x, -1);
        
        return solve(dp, 0, 0, m, n);
    }
}
