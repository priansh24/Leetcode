class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        String s = x+"";
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--)
        {
            sb.append(s.charAt(i));
        }
        String res = sb.toString();
        System.out.println(res);
        if(res.equals(s)) return true;
        else return false;
    }
}