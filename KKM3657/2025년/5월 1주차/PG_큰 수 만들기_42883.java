import java.util.ArrayDeque;

class Solution {
    public String solution(String number, int k) {
        String answer = "";

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<number.length(); i++) {
            char num = number.charAt(i);
            // 삭제할 숫자
            while(!stack.isEmpty() && k > 0 && stack.peek() < num) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }

        // k가 남는 경우 처리
        while(k-- > 0) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}