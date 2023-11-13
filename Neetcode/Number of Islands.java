class Solution {

    public void solve(char[][] grid, boolean[][] dfs, int m, int n, int i, int j){

        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] != '1' || dfs[i][j] == true) return;


        dfs[i][j] = true;

        solve(grid, dfs, m, n, i+1, j);
        solve(grid, dfs, m, n, i-1, j);
        solve(grid, dfs, m, n, i, j+1);
        solve(grid, dfs, m, n, i, j-1);
    }

    public int numIslands(char[][] grid) {

        int m = grid.length, n = grid[0].length;
        
        boolean dfs[][] = new boolean[m][n];
        int ans = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j] == '1' && dfs[i][j] == false){
                    ans++;
                    solve(grid, dfs, m, n, i, j);
                }
            }
        }
        return ans;

    }
}
