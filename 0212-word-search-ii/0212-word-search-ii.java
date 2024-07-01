class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        // Set<String> res = new HashSet<>();
        List<String> res = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        int flag = 0;
        for(String word:words)
        {
            boolean[][] visited = new boolean[m][n];
            for(int i = 0;i<m;i++)
            {
                for(int j = 0;j<n;j++)
                {
                    visited[i][j] = true;
                    if(board[i][j] == word.charAt(0) && check(board,visited,word,m,n,i,j,0))
                    {
                        flag=1;
                        res.add(word);
                    }
                    visited[i][j] = false;
                    if(flag==1) break;
                }
                if(flag==1)
                {
                    flag = 0;
                    break;
                }
            }
        }
        // return new ArrayList(res);
        return res;
    }

    private boolean check(char[][] board, boolean[][] visited, String word, int m, int n, int i, int j,int current)
    {
        if(current==word.length()-1) return true;

        if(i>0 && !visited[i-1][j] && board[i-1][j]==word.charAt(current+1))
        {
            visited[i-1][j] = true;
            if(check(board,visited,word,m,n,i-1,j,current+1)) return true;
            visited[i-1][j] = false;
        }
        if(j>0 && !visited[i][j-1] && board[i][j-1]==word.charAt(current+1))
        {
            visited[i][j-1] = true;
            if(check(board,visited,word,m,n,i,j-1,current+1)) return true;
            visited[i][j-1] = false;
        }
        if(i<m-1 && !visited[i+1][j] && board[i+1][j]==word.charAt(current+1))
        {
            visited[i+1][j] = true;
            if(check(board,visited,word,m,n,i+1,j,current+1)) return true;
            visited[i+1][j] = false;
        }
        if(j<n-1 && !visited[i][j+1] && board[i][j+1]==word.charAt(current+1))
        {
            visited[i][j+1] = true;
            if(check(board,visited,word,m,n,i,j+1,current+1)) return true;
            visited[i][j+1] = false;
        }
        return false;
    }
}