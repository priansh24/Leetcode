class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='(')
            {
                stack.push("(");
            }
            else if(ch==')')
            {
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && !stack.peek().equals("("))
                {
                    StringBuilder a = new StringBuilder(stack.pop());
                    sb.append(a.reverse());
                }
                stack.pop();
                stack.push(sb.toString());
            }
            else
            {
                stack.push(String.valueOf(ch));
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty())
        {
            res.insert(0,stack.pop());
        }
        return res.toString();
    }
}