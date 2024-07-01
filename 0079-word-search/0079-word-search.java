class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                visited[i][j] = true;
                if(board[i][j] == word.charAt(0) && check(board,visited,word, 0,i,j,m,n)) return true;
                visited[i][j] = false;
            }
        }
        return false;
    }

    private boolean check(char[][] board,boolean[][] visited, String word,int current,int i, int j,int m,int n)
    {
        if(current==word.length()-1) return true;

        if(i>0 && board[i-1][j]==word.charAt(current+1)&&!visited[i-1][j])
        {
            visited[i-1][j] = true;
            if(check(board,visited,word,current+1,i-1,j,m,n)) return true;
            visited[i-1][j] = false;
        }
        if(j>0 && board[i][j-1]==word.charAt(current+1) && !visited[i][j-1])
        {
            visited[i][j-1] = true;
            if(check(board,visited,word,current+1,i,j-1,m,n)) return true;
            visited[i][j-1] = false;
        }
        if(i<m-1 && board[i+1][j]==word.charAt(current+1) && !visited[i+1][j])
        {
            visited[i+1][j] = true;
            if(check(board,visited,word,current+1,i+1,j,m,n)) return true;
            visited[i+1][j] = false;
        }
        if(j<n-1 && board[i][j+1]==word.charAt(current+1) && !visited[i][j+1])
        {
            visited[i][j+1] = true;
            if(check(board,visited,word,current+1,i,j+1,m,n)) return true;
            visited[i][j+1] = false;
        }
        return false;
    }
}