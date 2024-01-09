class Solution {
    // TC will be n*m*^wordLength
    public boolean solve(char[][] board, String word, int index, int i, int j, boolean[][] vis){

        if(index == word.length()) return true;

        if(i<0 || j<0 || i>=board.length || j>= board[0].length || word.charAt(index) != board[i][j] || vis[i][j]) return false;

        vis[i][j] = true;

        boolean a = solve(board, word, index+1, i+1,j, vis) || 
                    solve(board, word, index+1, i-1,j, vis) || 
                    solve(board, word, index+1, i,j+1, vis) || 
                    solve(board, word, index+1, i,j-1, vis);

        vis[i][j] = false;

        return a;

    }

    public boolean exist(char[][] board, String word) {

        boolean[][] vis = new boolean[board.length][board[0].length];

        

        for(int i =0; i<board.length; i++)
        {
            for(int j =0; j < board[i].length; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                   if(solve(board, word, 0, i, j, vis)) return true;
                }
            }
        }
        return false;
        
    }
}
