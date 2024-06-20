class Solution {

    private boolean isPossible(int[] position,int distance,int m)
    {
        int count=1;
        int lastBallPos = position[0];
        for(int pos:position)
        {
            if(pos-lastBallPos>=distance)
            {
                count++;
                lastBallPos = pos;
            }
        }
        if(count>=m) return true;
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1;
        int high = position[n-1]-position[0];
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(isPossible(position,mid,m)) low=mid+1;
            else high = mid-1;
        }
        return high;
    }
}