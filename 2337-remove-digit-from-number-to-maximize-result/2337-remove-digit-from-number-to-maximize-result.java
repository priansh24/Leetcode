class Solution {
    public String removeDigit(String number, char digit) {
        String max = "";
        for(int i=0;i<number.length();i++)
        {
            char ch = number.charAt(i);
            if(ch==digit)
            {
                String s = number.substring(0,i)+number.substring(i+1,number.length());
                if(max.length()==0) max = s;
                // else max = s.compareTo(max)>0?s:max;
                else max = findGreaterString(s,max);
            }
        }
        return max;
    }
    private String findGreaterString(String a, String b)
    {
        for(int i = 0;i<a.length();i++)
        {
            if(a.charAt(i)>b.charAt(i)) return a;
            if(a.charAt(i)<b.charAt(i)) return b;
        }
        return a;
    }
}