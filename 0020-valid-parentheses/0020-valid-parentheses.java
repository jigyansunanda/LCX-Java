class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char openBracket = stack.pop();
                if (!isMatch(openBracket, c)) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(char openBracket, char closeBracket) {
        return (openBracket == '(' && closeBracket == ')') || (openBracket == '{' && closeBracket == '}') || (openBracket == '[' && closeBracket == ']');
    }
}