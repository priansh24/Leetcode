class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n,ans,new StringBuilder(),0,0);
        return ans;
    }

    private void helper(int n,List<String> ans,StringBuilder sb,int left, int right)
    {
        if(sb.length()==n*2)
        {
            ans.add(new String(sb.toString()));
            return;
        }
        if(left<n)
        {
            int len = sb.length();
            sb.append("(");
            helper(n,ans,sb,left+1,right);
            sb.setLength(len);
        }
        if(right<left)
        {
            int len = sb.length();
            sb.append(")");
            helper(n,ans,sb,left,right+1);
            sb.setLength(len);
        }
    }
}