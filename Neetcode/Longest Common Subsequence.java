class Solution {

    public int solve(int[][] dp, int m, int n, int i, int j, String str1, String str2){

        if(i<0 || j<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(str1.charAt(i) == str2.charAt(j)) return  dp[i][j] = 1 + solve(dp, m, n, i-1, j-1, str1, str2);

        else return dp[i][j] = Math.max(solve(dp, m, n, i, j-1, str1, str2), solve(dp, m, n, i-1, j, str1, str2));
    }

    public int longestCommonSubsequence(String str1, String str2) {
        
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m][n];

        for(int[] x : dp) Arrays.fill(x, -1);

        return solve(dp, m, n, m-1, n-1, str1, str2);
    }
}
