/*
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> ans = new ArrayList<>();
        int n = positions.length;
        if(n==1)
        {
            ans.add(healths[0]); return ans;
        }
        Arrays.sort(positions);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int currRobot = 1;
        while(currRobot<n)
        {
            int prevRobot = stack.peek();
            if(directions.charAt(currRobot)=='L' && directions.charAt(prevRobot)=='R')
            {
                if(healths[currRobot]==healths[prevRobot])
                {
                    stack.pop();
                    healths[currRobot] = 0;
                    healths[prevRobot] = 0;
                    currRobot++;
                }
                else if(healths[currRobot]>healths[prevRobot])
                {
                    healths[currRobot]--;
                    healths[prevRobot] = 0;
                    stack.pop();
                }
                else
                {
                    healths[currRobot] = 0;
                    healths[prevRobot]--;
                    currRobot++;
                }
            }
            stack.push(currRobot);
            currRobot++;
        }
        for(int health:healths)
        {
            if(health!=0) ans.add(health);
        }
        return ans;
    }
}
*/

class Solution {
    class Robot {
        int position;
        char direction;
        int health;
        int index;
        public Robot(int pos, char dir,int heal, int ind)
        {
            position = pos;
            direction = dir;
            health = heal;
            index = ind;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> ans = new ArrayList<>();
        int n = positions.length;
        if(n==1)
        {
            ans.add(healths[0]); return ans;
        }
        char[] dir = directions.toCharArray();
        Robot[] arr = new Robot[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = new Robot(positions[i],dir[i],healths[i],i);
        }
        Arrays.sort(arr,(a,b)->a.position-b.position);
        for(int i = 0;i<n;i++)
        {
            System.out.println(arr[i].position + " " + arr[i].direction  + " " + arr[i].health);
        }
        Stack<Robot> stack = new Stack<>();
        stack.push(arr[0]);
        Robot currRobot = arr[1];
        int i = 1;
        while(i<n)
        {
            if(stack.isEmpty()){
                stack.push(currRobot);
                continue;
            }
            currRobot = arr[i];
            Robot prevRobot = stack.peek();
            if(currRobot.direction=='L' && prevRobot.direction=='R')
            {
                if(currRobot.health==prevRobot.health)
                {
                    stack.pop();
                    currRobot.health = 0;
                    prevRobot.health = 0;
                }
                else if(currRobot.health>prevRobot.health)
                {
                    currRobot.health--;
                    prevRobot.health = 0;
                    stack.pop();
                    i--;
                }
                else
                {
                    currRobot.health = 0;
                    prevRobot.health--;
                }
            }
            else
            {
                stack.push(currRobot);
            }
            i++;
        }
        Arrays.sort(arr,(a,b)->a.index-b.index);
        if(stack.isEmpty()) return ans;
        for(Robot r: arr)
        {
            if(r.health!=0)
                ans.add(r.health);
        }
        return ans;
    }
}
