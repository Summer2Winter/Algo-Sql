import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(')
                stack.push(c);
            else {
                if(stack.isEmpty() || stack.peek() == ')')
                    return false;
                stack.pop();
            }
        }
        if(stack.isEmpty())
            answer = true;
        return answer;
    }
}