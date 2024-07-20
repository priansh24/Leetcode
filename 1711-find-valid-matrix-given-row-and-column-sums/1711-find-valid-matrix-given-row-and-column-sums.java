class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int totalRows = rowSum.length;
        int totalCols = colSum.length;
        int[][] res = new int[totalRows][totalCols];
        // for(int[] row: res) Arrays.fill(row,0);
        int currRow = 0, currCol = 0;
        while(currRow < totalRows && currCol < totalCols)
        {
            int val = Math.min(rowSum[currRow],colSum[currCol]);
            res[currRow][currCol] = val;
            rowSum[currRow] -= val;
            colSum[currCol] -= val;
            
            if(rowSum[currRow]==0) currRow++;
            if(colSum[currCol]==0) currCol++;
        }
        return res;


    }
}