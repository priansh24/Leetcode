class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        int i = 1;
        int curr = asteroids[i];
        while(i<asteroids.length)
        {
            System.out.println(i);
            if(stack.isEmpty())
            {
                stack.push(asteroids[i++]);
            }
            else
            {
                int prev = stack.peek();
                curr = asteroids[i];
                if((curr>0 && prev>0) || (curr<0 && prev<0) || (prev<0 && curr>0)) stack.push(curr);
                else if(Math.abs(curr)>Math.abs(prev))
                {
                    stack.pop(); i--;
                }
                else if(Math.abs(curr)==Math.abs(prev))
                {
                    stack.pop();
                }
                i++;
            }
        }
        if(stack.isEmpty()) return new int[0];
        int n = stack.size();
        int[] ans = new int[n];
        int ind = 0;
        while(!stack.isEmpty() && ind<n)
        {
            ans[n-1-ind] = stack.pop();
            ind++;
        }
        return ans;
    }
}