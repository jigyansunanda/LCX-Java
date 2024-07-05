class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else {
                    boolean isExploded = false;
                    while (!stack.isEmpty() && stack.peek() > 0) {
                        int collideWith = stack.pop();
                        // if same size, both explode
                        if (collideWith == Math.abs(asteroid)) {
                            isExploded = true;
                            break;
                        }
                        // bigger size positive, negative explodes
                        else if (collideWith > Math.abs(asteroid)) {
                            stack.push(collideWith);
                            isExploded = true;
                            break;
                        } else {
                            continue;
                        }
                    }
                    if (!isExploded) stack.push(asteroid);
                }
            }
        }
        int[] ans = new int[stack.size()];
        int index = ans.length - 1;
        while (index >= 0) {
            ans[index] = stack.pop();
            --index;
        }
        return ans;
    }
}
