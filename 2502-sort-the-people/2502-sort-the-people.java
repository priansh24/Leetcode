class Solution {
    class Pair {
        String name;
        int height;
        Pair(String name, int height)
        {
            this.name = name;
            this.height = height;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Pair[] arr = new Pair[n];
        for(int i = 0;i<n;i++)
        {
            arr[i] = new Pair(names[i],heights[i]); 
        }

        Arrays.sort(arr,(a,b)->b.height-a.height);

        for(int i=0;i<n;i++)
        {
            names[i] = arr[i].name;
        }
        return names;
    }
}