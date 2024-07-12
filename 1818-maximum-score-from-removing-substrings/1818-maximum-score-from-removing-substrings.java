class Solution {
    // public int maximumGain(String s, int x, int y) {
    //     int ans = 0;
    //     String ab = "ab";
    //     String ba = "ba";
    //     String s1 = s;
    //     int[] res = new int[2];
    //     s = helper(s,ab,x,res,0);
    //     s = helper(s,ba,y,res,0);

    //     s1 = helper(s1,ba,y,res,1);
    //     s1 = helper(s1,ab,x,res,1);

    //     ans = Math.max(res[0],res[1]);

    //     return ans;
    // }

    // private String helper(String s, String replace, int points, int[] res,int index)
    // {
    //     String s1 = s;
    //     while(s1.indexOf(replace)>=0)
    //     {
    //         s1 = s.replace(replace,"");
    //         int count = (s.length()-s1.length())/2;
    //         res[index] += count*points;
    //         s=s1;
    //     }
    //     return s1;
    // }
    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int big = x>y?x:y;
        int small = big==x?y:x;
        char first = big==x?'a':'b';
        char second = first=='a'?'b':'a';
        int points  = 0;
        for(char ch:s.toCharArray())
        {
            if(ch==second && !stack1.isEmpty() && stack1.peek()==first)
            {
                stack1.pop();
                points += big;
            }
            else stack1.push(ch);
        }

        while(!stack1.isEmpty())
        {
            char ch = stack1.pop();
            if(ch==second && !stack2.isEmpty() && stack2.peek()==first)
            {
                stack2.pop();
                points += small;
            }
            else stack2.push(ch);
        }
        return points;
    }
}