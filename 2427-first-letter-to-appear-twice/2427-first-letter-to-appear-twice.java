class Solution {
    public char repeatedCharacter(String s) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(set.contains(ch)) return ch;
            else set.add(ch);
        }
        return 'a';
    }
}