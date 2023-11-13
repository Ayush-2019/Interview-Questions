class Solution {

    public int solve(int[][] mat, int[][] dfs, int m, int n, int i, int j){

        if(i<0 || j<0 ||i>=m || j>=n) return 0;



        if(dfs[i][j] != -1) return dfs[i][j];
        int res = 1;
        if(i+1<m && mat[i][j] < mat[i+1][j])  res = Math.max(res, 1 + solve(mat, dfs, m, n, i+1, j));
        if(i-1>=0 && mat[i][j] < mat[i-1][j])  res = Math.max(res, 1 + solve(mat, dfs, m, n, i-1, j));
        if(j+1<n && mat[i][j] < mat[i][j+1])  res = Math.max(res, 1 + solve(mat, dfs, m, n, i, j+1));
        if(j-1>=0 && mat[i][j] < mat[i][j-1])  res = Math.max(res, 1 + solve(mat, dfs, m, n, i, j-1));

        return dfs[i][j] = res;
    }

    public int longestIncreasingPath(int[][] mat) {

        int m = mat.length, n = mat[0].length;

        int[][] dfs = new int[m][n];

        for(int[] x: dfs) Arrays.fill(x, -1);

        int ans = Integer.MIN_VALUE;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                ans = Math.max(ans, solve(mat, dfs, m, n, i, j));
            }
        }
        return ans;
    }
}
