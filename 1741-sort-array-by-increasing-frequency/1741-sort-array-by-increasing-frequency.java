class Solution {
    class Pair{
        int num, freq;
        Pair(int n, int f)
        {
            num = n;
            freq = f;
        }
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums) map.put(i, map.getOrDefault(i,0)+1);
        List<Pair> arr = new ArrayList<>();
        int i = 0;
        for(Map.Entry<Integer,Integer> e: map.entrySet())
        {
            arr.add(new Pair(e.getKey(),e.getValue()));
        }
        int n = arr.size();
        // for(Pair p:arr) System.out.println(p.num+" "+p.freq);
        Collections.sort(arr,(a,b)->{
            if(a.freq!=b.freq) return a.freq-b.freq;
            else return b.num-a.num;
        });
        int index = 0;
        for(i = 0;i<n;i++)
        {
            int freq = arr.get(i).freq;
            while(freq-->0) nums[index++] = arr.get(i).num;
        }
        return nums;
    }
}