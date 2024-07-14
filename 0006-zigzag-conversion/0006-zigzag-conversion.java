class Solution {
    public String convert(String s, int numRows) {
        int n = 2*(numRows-1);
        int i = 0,j=0;
        int pat = n;
        int tempPatt = n;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        if(numRows==1) return s;
        while(j<numRows)
        {
            while(i<len)
            {
                sb.append(s.charAt(i));
                i = i+pat;
                if(n-pat>0)
                {
                    pat = n-pat;
                }
            }
            j++;
            tempPatt -= 2;
            pat = tempPatt;
            i=j;
            if(pat==0) pat = n;
        }
        return sb.toString();

    }
}