class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int degree[] = new int[n];
        for(int[] road:roads)
        {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        // // int cities[] = new int[n];
        // Integer cities[] = new Integer[n];
        // for(int i =0;i<n;i++)
        // {
        //     cities[i] = i;
        // }

        // Arrays.sort(cities,(a,b)->Integer.compare(degree[b],degree[a]));

        // int currentVal = n;

        // int val[] = new int[n];
        // for(int city:cities)
        // {
        //     val[city] = currentVal;
        //     currentVal--;
        // }

        // long ans = 0;

        // for(int[] road :roads)
        // {
        //     ans += val[road[0]] + val[road[1]];
        // }

        Arrays.sort(degree);
        long val = 1;
        long ans = 0;
        for(int deg:degree)
        {
            ans += (val*deg);
            val++;
        }
        return ans;
    }
}