class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++) list.add(i+1);

        int temp = k;
        int i = 0;
        while(list.size()!=1)
        {
            temp--;
            if(i==list.size()) i = 0;
            if(temp==0)
            {
                list.remove(i--);
                temp = k;
            }
            i++;
        }
        return list.get(0);
    }
}