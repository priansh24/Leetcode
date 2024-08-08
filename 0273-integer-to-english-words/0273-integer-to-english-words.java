class Solution {
    String[] BELOW20 = new String[] {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty"};
    String[] TENS = new String[] {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] THOUSANDS = new String[] {"","Thousand", "Million","Billion"};

    public String numberToWords(int num) {
        if(num==0) return "Zero";

        int i = 0;
        String words = "";
        while(num>0)
        {
            if(num%1000!=0)
            {
                words = helper(num%1000) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }
        return words.trim();
    }

    private String helper(int num)
    {
        if(num==0) return "";
        else if(num<20) return BELOW20[num] + " ";
        else if(num<100) return TENS[num/10] + " " + helper(num%10);
        else return BELOW20[num/100] + " Hundred " + helper(num%100);
    }
}