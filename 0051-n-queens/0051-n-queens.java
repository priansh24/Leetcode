class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        NQueens(board,0,res);
        return res;
    }
    private void NQueens(boolean[][] board,int row,List<List<String>> res)
    {
        if(row==board.length)
        {
            res.add(display(board));
            return;
        }

        int count = 0;
        for(int col = 0;col<board.length;col++)
        {
            if(isSafe(board,row,col))
            {
                board[row][col] = true;
                NQueens(board,row+1,res);
                board[row][col] = false;
            }
        }
        return;
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

    private List<String> display(boolean[][] board)
    {
        List<String> list = new ArrayList<>();
        for(boolean[] row:board)
        {
            StringBuilder sb  = new StringBuilder();
            for(boolean element: row)
            {
                if(element) sb.append("Q");
                else sb.append(".");
            }
            list.add(sb.toString());
        }
        // res.add(list);
        return list;
    }
}