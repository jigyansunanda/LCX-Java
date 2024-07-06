class State {
    String sequence;
    int openBracket, closeBracket;

    State(String sequence, int openBracket, int closeBracket) {
        this.sequence = sequence;
        this.openBracket = openBracket;
        this.closeBracket = closeBracket;
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        Stack<State> stack = new Stack<>();
        stack.push(new State("(", 1, 0));
        while (!stack.isEmpty()) {
            State state = stack.pop();
            int openBracket = state.openBracket;
            int closeBracket = state.closeBracket;
            String sequence = state.sequence;
            if (openBracket == closeBracket && openBracket == n) {
                parenthesis.add(sequence);
            } else {
                if (openBracket < n) {
                    stack.push(new State(sequence + "(", openBracket + 1, closeBracket));
                }
                if (closeBracket < openBracket) {
                    stack.push(new State(sequence + ")", openBracket, closeBracket + 1));
                }
            }
        }
        return parenthesis;
    }
}