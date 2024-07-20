class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] res = new int[m][n];
        for(int[] row: res) Arrays.fill(row,0);
        int currRow = 0, currCol = 0;
        while(currRow<m && currCol<n)
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