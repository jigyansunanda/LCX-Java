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
        int value = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                value -= map.get(s.charAt(i));
            } else {
                value += map.get(s.charAt(i));
            }
        }
        return value;
    }
}