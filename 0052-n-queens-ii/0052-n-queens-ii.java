class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return NQueens(board,0);
    }

    private int NQueens(boolean[][] board,int row)
    {
        if(row==board.length)
            return 1;

        int count = 0;
        for(int col = 0;col<board.length;col++)
        {
            if(isSafe(board,row,col))
            {
                board[row][col] = true;
                count += NQueens(board,row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private boolean isSafe(boolean[][] board, int row,int col)
    {
        //vertical column check
        for(int i = 0;i<board.length;i++)
        {
            if(board[i][col]) return false;
        }

        // diagonal left check
        int maxLeftDiagonalSquares = Math.min(row,col);
        for(int i = 1;i<=maxLeftDiagonalSquares;i++)
        {
            if(board[row-i][col-i]) return false;
        }

        //diagonal right check
        int maxRightDiagonalSquares = Math.min(row,board.length-col-1);
        for(int i = 1;i<=maxRightDiagonalSquares;i++)
        {
            if(board[row-i][col+i]) return false;
        }

        return true;
    }
}