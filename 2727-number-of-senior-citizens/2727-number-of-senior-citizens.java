class Solution {
    public int countSeniors(String[] details) {
        List<Integer> list = new ArrayList<>();
        for(String p:details)
        {
            int age = Integer.parseInt(p.substring(11,13));
            if(age>60) list.add(age);
        }
        return list.size();
    }
}