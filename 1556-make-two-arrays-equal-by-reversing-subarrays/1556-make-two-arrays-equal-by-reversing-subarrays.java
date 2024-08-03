class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] check = new int[1001];
        for(int i=0;i<arr.length;i++)
        {
            check[arr[i]]++;
            check[target[i]]--;
        }
        for(int i:check)
        {
            if(i!=0) return false;
        }
        return true;
    }
}