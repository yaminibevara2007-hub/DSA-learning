class Solution {
    public String decodeString(String s) {
        Stack<Object[]> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int number = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }
            else if (ch == '[') {
                stack.push(new Object[]{current, number});
                current = new StringBuilder();
                number = 0;
            }
            else if (ch == ']') {
                Object[] data = stack.pop();
                StringBuilder previous = (StringBuilder) data[0];
                int repeat = (int) data[1];
                for (int i = 0; i < repeat; i++) {
                    previous.append(current);
                }
                current = previous;
            }
            else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}