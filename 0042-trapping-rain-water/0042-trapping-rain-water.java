class Solution {
    public int trap(int[] height) {
        int waterTrapped = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; ++i) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int index = stack.pop();
                if (stack.isEmpty()) break;
                int rightIndex = i;
                int leftIndex = stack.peek();
                int width = i - leftIndex - 1;
                int h = Math.min(height[leftIndex], height[rightIndex]) - height[index];
                waterTrapped += (h * width);
            }
            stack.push(i);
        }
        return waterTrapped;
    }
}