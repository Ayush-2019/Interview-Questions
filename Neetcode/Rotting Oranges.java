class Solution {

    int m, n, c, fresh;

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
 
    public void bfs(int[][] grid, Queue<int[]> q){

        while(!q.isEmpty()){
            int size = q.size();
            boolean check = false;

            while(size>0){

            int[] curr = q.remove();
            int i = curr[0];
            int j = curr[1];

            for(int k = 0;k<4;k++){
                int newR = dir[k][0] + i;
                int newC = dir[k][1]+j;

                if(newR<0 || newC<0 || newR>=m || newC>=n || grid[newR][newC] != 1) continue;
                q.add(new int[]{newR,newC});
                check = true;
                grid[newR][newC] = 2;
                fresh--;

            }
            
            size--;
            }

            if(check == true) c++;
        }
    }

    public int orangesRotting(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
        c = 0;

        Queue<int[]> q = new LinkedList<>();

        fresh = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j] == 2) q.add(new int[]{i, j});
                if(grid[i][j] == 1) fresh++;
            }
        }

        bfs(grid,q);

        if(fresh !=0) return -1;

        return c;
        
    }
}
