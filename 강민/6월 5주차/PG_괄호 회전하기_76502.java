import java.util.LinkedList;
import java.util.ArrayDeque;

class Solution {
    LinkedList<Character> word = new LinkedList<>();
    ArrayDeque<Character> stack;
    public int solution(String s) {
        int answer = 0;

        for(int i=0; i<s.length(); i++) {
            word.add(s.charAt(i));
        }

        for(int i=0; i<s.length(); i++) {
            // 올바른 괄호 문자열 확인
            if(isCorrect()) {
                answer++;
            }
            // 문자열 회전
            char letter = word.removeFirst();
            word.add(letter);
        }
        return answer;
    }
    public boolean isCorrect() {
        // Stack 선언
        stack = new ArrayDeque<>();

        // 올바른 괄호 확인
        for(int i=0; i<word.size(); i++) {
            char l = word.get(i);

            switch(l) {
                case '(' : case '[' : case '{' :{
                    stack.add(l);
                    break;
                }
                case ')' : case ']': case '}' :{
                    if(!isPossible(l))
                        return false;
                    break;
                }
            }
        }
        // 올바른 괄호열 확인
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
    public boolean isPossible(char l) {
        // 올바른 괄호 확인
        while(!stack.isEmpty()) {
            // 뽑기
            char now = stack.removeLast();
            if((l == ')' && now == '(')
                    || (l == ']' && now == '[')
                    || (l == '}' && now == '{')
            )
                return true;
            else
                return false;
        }
        return false;
    }

}