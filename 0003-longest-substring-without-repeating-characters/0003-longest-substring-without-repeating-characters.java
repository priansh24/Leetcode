class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        boolean[] list = new boolean[256];
        int i = 0,j=-1,max=1,currentLen = 0;
        if(len==0) return 0;
        while(i<len)
        {
            char charToAcquire = s.charAt(i);
            while(list[charToAcquire]==true)
            {
                j++;
                char charToRelease = s.charAt(j);
                list[charToRelease] = false;
            }
            list[charToAcquire] = true;
            currentLen = i-j;
            max = Math.max(max,currentLen);
            i++;
        }



        return max;
    }
}