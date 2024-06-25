/*
 * Idea:
 * 1. Maintain one stack for input values
 * 2. Maintain one variable `minValue` with the invariance that
 *    at any instance minValue <= stack.top()
 * 3. push(x):
 *      - if x > minValue: simply push
 *      - if x <= minValue: push some value smaller
 *        than x (new minValue), i.e. x + (x - minValue)
 *        because (x - minValue) <= 0 and minValue = x
 *        This will help mark the minValue changes
 * 4. top():
 *      - say x = current top of stack
 *      - if x > minValue: return x
 *      - if x <= minValue: return minValue
 *        during push we pushed value that is
 *        smaller than the actual minValue.
 *        Actual minValue was the real value.
 * 5. pop():
 *      - say x = current top of stack
 *      - if x > minValue: return. no need to update minValue
 *      - if x <= minValue: roll back previous
 *        minValue then return
 *        top = minValue + (minValue - previousMinValue)
 *        previousMinValue = 2 * minValue - top
 */

class MinStack {
    private Stack<Long> stack;
    private long minValue;

    public MinStack() {
        this.stack = new Stack<>();
        this.minValue = 0;
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push((long) val);
            minValue = val;
        } else {
            if (val > minValue) {
                stack.push((long) val);
            } else {
                stack.push(val + (val - minValue));
                minValue = val;
            }
        }
    }

    public void pop() {
        long topVal = stack.pop();
        if (topVal <= minValue) {
            long prevMinValue = 2L * minValue - topVal;
            minValue = prevMinValue;
        }
    }

    public int top() {
        long topValue = stack.peek();
        return (stack.peek() > minValue) ? (int) topValue : (int) minValue;
    }

    public int getMin() {
        return (int) minValue;
    }
}