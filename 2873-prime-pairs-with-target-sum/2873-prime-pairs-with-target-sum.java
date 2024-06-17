class Solution {
    public void findAllPrimes(int n, int[] primes)
    {
        Arrays.fill(primes,1);
        for(int i = 2;i<=Math.sqrt(n);i++)
        {
            if(primes[i]==1)
            {
                for(int j = i*i;j<=n;j+=i)
                {
                    primes[j] = 0;
                }
            }
        }
    }

    public List<List<Integer>> findPrimePairs(int n) {
        // code here
        List<List<Integer>> ans = new ArrayList<>();
        int[] primes = new int[n+1];
        findAllPrimes(n,primes);
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(-1);
        // list.add(-1);
        for(int i = 2;i<=n/2;i++)
        {
            if(primes[i]==1 && primes[n-i]==1)
            {
                // ArrayList<Integer> list = new ArrayList<>();
                // // list.set(0,i);
                // // list.set(1,n-i);
                // list.add(i);
                // list.add(n-i);
                // ans.add(list);
                ans.add(Arrays.asList(i, n - i));
            }
        }
        return ans;
    }
}