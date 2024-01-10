// Explanation
// Create an nxn board of chars and fill it with '.'
// Run the function solve with current position as 0, 0 and n queens unplaced

// For Solve:-

// if n is 0, we got all queens placed, add the board to ans

// iterate from i of last queen placed
// iterate j from 0 to num(=n)

// if current grid is before or equal to last queen placed or i is 0(else function wont allow you to place queen at 0,0 or position is dangerous), continue

// if you can com at this stage:
// mark current grid to 'Q'
// add this position to positions list
// recursively call for n-1, i, j

// when you backtrack:
// mark the grid again to '.'
// remove lst element of positions list(which is last placed queen)

// Now, how to check that position is dangerous:

// from the list positions, that contains position of current queens:

// if current position has same row or same column or

// sum of a placed queens i and j is equal to sum or current positions i and j
// or

// absolute difference of a placed queens i and j is equal to sum or current positions i and j

// and and and most important
// with this condition absolute difference of 2 i's is equal to absolute difference of 2 j's (this one's is a bit triky but if you'll make a grid onpaper and try to figure out, you will get it for sure)

// then
// return true here

class Solution {

    List<List<String>> ans;
    List<int[]> positions;
    int num;

    public boolean checkDanger(int i, int j){

        for(int[] pos: positions){

            int qi = pos[0], qj = pos[1];

            if(i == qi || j == qj || (Math.abs(qi-qj) == Math.abs(i-j) && Math.abs(i-qi) == Math.abs(j-qj)) || qi+qj == i+j) {

                return true;
            }
        }

        return false;


    }

    public void solve(char[][] board, int n, int lasti, int lastj){

        if(n == 0){

            List<String> list = new ArrayList<>();

            for(int i=0;i<board.length;i++){
                StringBuilder s = new StringBuilder();
                for(int j=0;j<board.length;j++){
                    s.append(board[i][j]);
                }
                list.add(s.toString());
            }

            ans.add(list);
            return;
        }

        for(int i = lasti;i<num;i++){
            for(int j=0;j<num;j++){

                if((i != 0 && i == lasti && j <= lastj) || checkDanger(i, j)) continue;

                board[i][j] = 'Q';
                positions.add(new int[]{i, j});
                solve(board, n-1, i, j);
                board[i][j] = '.';
                positions.remove(positions.size()-1);
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {

        ans = new ArrayList<>();
        positions = new ArrayList<>();
        num = n;

        char[][] board = new char[n][n];

        for(char[] c: board) Arrays.fill(c, '.');

        solve(board, n, 0, 0);
        return ans;
        
    }
}
