class Solution {
    public int scoreOfParentheses(String s) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(0);
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else {
                int val = Math.max(2 * stack.pop(), 1);
                stack.push(stack.pop() + val);
            }
        }
        
        return stack.pop();
    }
}