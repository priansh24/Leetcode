class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfied = 0, addSatisfied = 0, currWindow = 0;
        for(int i=0;i<n;i++)
        {
            if(grumpy[i]==0)
            {
                satisfied += customers[i];
            }
        }
        for(int i = 0;i<minutes;i++)
        {
            if(grumpy[i]==1)
            {
                currWindow += customers[i];
            } 
        }
        addSatisfied = currWindow;
        for(int i = minutes;i<n;i++)
        {
            if(grumpy[i]==1)
            {
                currWindow += customers[i];
            }
            if(grumpy[i-minutes]==1) currWindow -= customers[i-minutes];
            addSatisfied = Math.max(addSatisfied,currWindow);
        }
        return satisfied + addSatisfied;
    }
}