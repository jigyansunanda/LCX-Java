class Solution {
    static final HashMap<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int index = 0, value = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == 'I') {
                if (index + 1 < s.length() && (s.charAt(index + 1) == 'V' || s.charAt(index + 1) == 'X')) {
                    value += map.get(s.charAt(index + 1)) - map.get(c);
                    index += 2;
                } else {
                    value += map.get(c);
                    index += 1;
                }
            } else if (c == 'X') {
                if (index + 1 < s.length() && (s.charAt(index + 1) == 'L' || s.charAt(index + 1) == 'C')) {
                    value += map.get(s.charAt(index + 1)) - map.get(c);
                    index += 2;
                } else {
                    value += map.get(c);
                    index += 1;
                }
            } else if (c == 'C') {
                if (index + 1 < s.length() && (s.charAt(index + 1) == 'D' || s.charAt(index + 1) == 'M')) {
                    value += map.get(s.charAt(index + 1)) - map.get(c);
                    index += 2;
                } else {
                    value += map.get(c);
                    index += 1;
                }
            } else {
                value += map.get(c);
                index += 1;
            }
        }
        return value;
    }
}
