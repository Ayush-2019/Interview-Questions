class Solution {
    int m, n;

    public void dfs(int[][] grid,boolean[][] vis, int height, int i, int j){

            if(i<0 || j<0 || i>=m || j>=n || grid[i][j]<height || vis[i][j] == true) return;

            vis[i][j] = true;

            dfs(grid, vis, grid[i][j], i+1, j);
            dfs(grid, vis, grid[i][j], i-1, j);
            dfs(grid, vis, grid[i][j], i, j+1);
            dfs(grid, vis, grid[i][j], i, j-1);

    }

    public List<List<Integer>> pacificAtlantic(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        List<List<Integer>> ans = new ArrayList<>();

        for(int c=0;c<n;c++){
            dfs(grid, pac, grid[0][c], 0, c);
            dfs(grid, atl, grid[m-1][c], m-1, c);
        }

        for(int r=0;r<m;r++){
            dfs(grid, pac, grid[r][0], r, 0);
            dfs(grid, atl, grid[r][n-1], r, n-1);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pac[i][j] == true && atl[i][j] == true){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        
        return ans;
    }
}
