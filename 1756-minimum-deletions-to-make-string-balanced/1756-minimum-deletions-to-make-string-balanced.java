class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i = n-1;i>=0;i--)
        {
            char ch = s.charAt(i);
            if(!stack.isEmpty() && ch>stack.peek())
            {
                stack.pop();
                count++;
            }
            else stack.push(ch);
        }
        return count;
    }
}