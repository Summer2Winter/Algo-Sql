import java.util.ArrayDeque;

class Solution {
    ArrayDeque<String> answerList = new ArrayDeque<>();
    public String solution(String p) {
        String answer = "";
        // 올바른 괄호 확인
        boolean flag = isCorrect(p);
        if(flag)
            return p;
        else
            return makeCorrect(p);
    }

    public String makeCorrect(String str) {
        // 빈 문자열이면 넘어감
        if(str.equals(""))
            return "";

        // 문자열 u,v 분리
        String[] split = makeUV(str);
        String u = split[0], v = split[1];

        StringBuilder sb = new StringBuilder();
        // u가 올바른 문자열
        if(isCorrect(u)) {
            // U 추가
            sb.append(u);
            sb.append(makeCorrect(v));
        }
        else {
            sb.append('(');
            sb.append(makeCorrect(v));
            sb.append(')');
            // u의 1, 마지막 제거, 방향 전환
            for(int i=1; i<u.length()-1; i++) {
                char temp = u.charAt(i);
                if(temp == '(')
                    sb.append(')');
                else
                    sb.append('(');
            }
        }
        return sb.toString();
    }

    // 분리
    public String[] makeUV(String str) {
        int rCnt = 0, lCnt = 0, idx = -1;
        for(int i=0; i<str.length(); i++) {
            char temp = str.charAt(i);
            if(temp == '(')
                rCnt++;
            else
                lCnt++;
            if(rCnt == lCnt) {
                idx = i;
                break;
            }
        }
        return new String[]{str.substring(0,idx+1), str.substring(idx+1)};
    }
    public boolean isCorrect(String str) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);
            // '('
            if(curr == '(')
                stack.push('(');
                // ')'
            else {
                // 비어있는 경우 불가능
                if(stack.isEmpty()) return false;
                // '('가 위에 없으면 불가능
                if(stack.peek() != '(') return false;
                stack.pop();
            }
        }
        // 남은게 있으면 불가능
        if(!stack.isEmpty()) return false;

        return true;
    }
}