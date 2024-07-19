class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> minis = new ArrayList<>();
        List<Integer> maxis = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int mat[][] = new int[n][m];
        for(int[] row: matrix)
        {
            int min = Integer.MAX_VALUE;
            for(int j: row)
            {
                min = min<j?min:j;
            }
            minis.add(min);
        }

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                int temp = mat[i][j];
                mat[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int[] row: mat)
        {
            int max = Integer.MIN_VALUE;
            for(int j: row)
            {
                max = max>j?max:j;
            }
            if(minis.contains(max)) ans.add(max);
            maxis.add(max);
        }

        // for(int i:maxis)
        // {
        //     if(minis.contains(i)) ans.add(i);
        // }
        return ans;
    }
}