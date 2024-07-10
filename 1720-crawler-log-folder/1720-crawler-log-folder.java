class Solution {
    public int minOperations(String[] logs) {
        List<String> list = new ArrayList<>();
        for(String s:logs)
        {
            if(!s.equals("./")) list.add(s);
        }
        int count = 0;
        for(String s:list)
        {
            if(s.charAt(0)=='.') count = Math.max(0,count-1);
            else count++;
        }
        return count;
    }
}