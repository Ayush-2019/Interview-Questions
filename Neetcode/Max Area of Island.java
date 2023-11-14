class Solution {

    int count = 0;

    public void solve(int[][] grid, boolean[][] dfs, int m, int n, int i, int j){

        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] != 1 || dfs[i][j] == true) return;


        dfs[i][j] = true;
        count++;

        solve(grid, dfs, m, n, i+1, j);
        solve(grid, dfs, m, n, i-1, j);
        solve(grid, dfs, m, n, i, j+1);
        solve(grid, dfs, m, n, i, j-1);
    }

    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        
        boolean dfs[][] = new boolean[m][n];
        int ans = Integer.MIN_VALUE;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                count = 0;

                if(grid[i][j] == 1){

                    solve(grid, dfs, m, n, i, j);
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
        
    }
}
