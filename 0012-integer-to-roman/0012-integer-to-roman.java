class Solution {
    void process(StringBuilder sb,char major,char middle,char minor, int val)
    {
        if(val<=3)
        {
            for(int i = 1;i<=val;i++)
            {
                sb.append(minor);
            }
        }
        else if(val==4)
        {
            sb.append(minor);
            sb.append(middle);
        }
        else if(val==5) sb.append(middle);
        else if(val>5 && val<9)
        {
            sb.append(middle);
            for(int i = 6;i<=val;i++)
            {
                sb.append(minor);
            }
        }
        else
        {
            sb.append(minor);
            sb.append(major);
        }

    }
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        process(sb,'_','_','M',num/1000);
        num %= 1000;
        process(sb,'M','D','C',num/100);
        num %= 100;
        process(sb,'C','L','X',num/10);
        num %=10;
        process(sb,'X','V','I',num);
        return sb.toString();
    }
}