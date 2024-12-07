import java.util.ArrayDeque;

class Solution {
    public int solution(String s) {
        int answer = -1;
        // Stack 이용
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            // 같으면 제거
            if(!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }
        if(stack.isEmpty())
            answer = 1;
        else
            answer = 0;
        return answer;
    }
}