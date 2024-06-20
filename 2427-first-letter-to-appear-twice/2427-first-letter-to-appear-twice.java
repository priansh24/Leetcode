class Solution {
    public char repeatedCharacter(String s) {
        int freq[] = new int[26];
        Arrays.fill(freq,0);
        for(int i = 0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(freq[ch-'a']==1) return ch;
            else freq[ch-'a']++;
        }
        return 'a';
    }
}