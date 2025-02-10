import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    long answer;
    boolean[] selected;
    ArrayList<String> priority = new ArrayList<>();
    ArrayList<String> temp, operand;
    public long solution(String expression) {
        operand = new ArrayList<>();

        // 연산자 종류 확인
        if(expression.contains("*")) {
            operand.add("*");
        }
        if(expression.contains("+")) {
            operand.add("+");
        }
        if(expression.contains("-")) {
            operand.add("-");
        }

        // 연산자 우선 순위 만들기
        selected = new boolean[operand.size()];
        makeOperand(0, expression);

        return answer;
    }
    public void makeOperand(int select, String expression) {
        // 선택완료
        if(select == operand.size()) {
            // System.out.println(priority.toString());
            // 우선순위 대로 계산
            temp = new ArrayList<>();
            for(String str : priority)
                temp.add(str);

            long result = calculateExpression(expression);
            answer = Math.max(answer, Math.abs(result));
            return;
        }

        // 우선순위 정하기
        for(int i=0; i<operand.size(); i++) {
            if(selected[i])
                continue;
            // 선택
            selected[i] = true;
            priority.add(operand.get(i));
            makeOperand(select+1, expression);

            // 초기화
            selected[i] = false;
            priority.remove(priority.size()-1);
        }
    }

    public long calculateExpression(String expression) {
        // 연산자가 한 개 남은 경우
        if(temp.size() == 1) {
            return calculateCurr(expression, temp.get(0));
        }
        // 연산자가 2개 이상 남은 경우
        else {
            String cut = "";
            for(int i=1; i<temp.size(); i++)
                cut += temp.get(i);
            // 분할
            StringTokenizer st = new StringTokenizer(expression, cut, true);

            StringBuilder sb = new StringBuilder();
            while(st.hasMoreTokens()) {
                String next = st.nextToken();
                if(!next.contains(temp.get(0)))
                    sb.append(next);
                    // 있다면 계산해서 넣기
                else {
                    // System.out.println(next);
                    long value = calculateCurr(next, temp.get(0));
                    sb.append(value);
                }
            }
            temp.remove(0);
            return calculateExpression(sb.toString());
        }
    }

    // 구간 계산
    public long calculateCurr(String currString, String currOperand) {
        // 연산할 숫자들을 분리
        String[] number = currString.split("\\" + currOperand);
        long result = Long.parseLong(number[0]); // 첫 번째 숫자를 초기값으로 설정

        // 두 번째 숫자부터 반복해서 연산 수행
        for (int i = 1; i < number.length; i++) {
            long num = Long.parseLong(number[i]);

            // 연산자에 따라 연산 수행
            if (currOperand.equals("+")) {
                result += num;
            } else if (currOperand.equals("-")) {
                result -= num;
            } else if (currOperand.equals("*")) {
                result *= num;
            }
        }
        return result;
    }
}