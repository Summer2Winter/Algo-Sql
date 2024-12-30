import java.util.LinkedList;
import java.util.ArrayDeque;

class Solution {
    LinkedList<Character> letter = new LinkedList<>();
    public int solution(String s) {
        int answer = 0;

        // 문자열 리스트
        for(int i=0; i<s.length(); i++)
            letter.add(s.charAt(i));

        // 회전
        for(int i=0; i<s.length(); i++) {
            // 판별
            if(isPossible())
                answer++;
            // 이동
            letter.addLast(letter.removeFirst());
        }
        return answer;
    }
    public boolean isPossible() {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<letter.size(); i++) {
            if(letter.get(i) == '{' || letter.get(i) == '[' || letter.get(i) == '(')
                stack.push(letter.get(i));
            else {
                if(stack.isEmpty())
                    return false;
                else {
                    if(letter.get(i) == '}' && stack.peek() != '{' ||
                            letter.get(i) == ']' && stack.peek() != '[' ||
                            letter.get(i) == ')' && stack.peek() != '(')
                        return false;
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}