class Solution {
    public int numDifferentIntegers(String word) {
int l = word.length();
        if (l == 1) {
            return word.charAt(0) <= '9' ? 1 : 0;
        }
        
        char[] arr = word.toCharArray();
     
        if ((arr[0] == '0' && arr[1] <= '9') || arr[0] > '9') {
            arr[0] = ' ';
        }

        for (int i = 1; i < l; i++) {
            if (i < l - 1 && arr[i] == '0' && arr[i - 1] == ' ' && arr[i + 1] <= '9') {
                arr[i] = ' ';
            } else if (arr[i] > '9') {
                arr[i] = ' ';
            }
        }
        HashSet<String> set = new HashSet<>();
        StringBuilder num = new StringBuilder();
        for (char c : arr) {
            if (c != ' ') {
                num.append(c);
            } else if (num.length() > 0) {
                set.add(num.toString());
                num.setLength(0);
            }
        }
        if (num.length() > 0) {
            set.add(num.toString());
        }
        return set.size();
    }
}