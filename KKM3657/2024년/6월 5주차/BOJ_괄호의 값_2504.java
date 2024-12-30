import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    static Stack<String> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] array = new char[str.length()];

        // 분할
        for(int i=0; i<str.length(); i++) {
            array[i] = str.charAt(i);
            // System.out.println(array[i]);
        }

        // Stack을 활용한 점수 구하기
        int answer = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = array[i];
            // System.out.println(ch);
            switch(ch) {
                case '(': {
                    stack.push("(");
                    break;
                }
                case '[': {
                    stack.push("[");
                    break;
                }
                case ')': {
                    // 점수 계산하기 및 판별
                    int value = calculateValue(")");

                    // 올바른 괄호 아님
                    if (value == -1)
                        answer = -1;
                    else
                        stack.push(String.valueOf(value));
                    break;
                }
                case ']': {
                    // 점수 계산하기 및 판별
                    int value = calculateValue("]");

                    // 올바른 괄호 아님
                    if (value == -1)
                        answer = -1;
                    else
                        stack.push(String.valueOf(value));
                    break;
                }
            }
            if(answer == -1) {
                System.out.println(0);
                System.exit(0);
            }
        }
        while(!stack.isEmpty()) {
            String ch = stack.pop();
            if(ch.equals("(") || ch.equals("[") || ch.equals(")") || ch.equals("]")) {
                System.out.println(0);
                System.exit(0);
            }
            answer += Integer.parseInt(ch);
        }
        System.out.println(answer);
    }

    public static int calculateValue(String ch) {
        int value = 1;
        if(ch.equals(")")) {
            // 하나씩 확인
            while(!stack.isEmpty()) {
                String str = stack.pop();
                // 완전한 괄호열
                if(str.equals("(")) {
                    value *= 2;
                    // System.out.println(value);
                    return value;
                }
                if(str.equals("[")) {
                    System.out.println(0);
                    System.exit(0);
                }
                else {
                    if(value == 1) {
                        value *= Integer.parseInt(str);
                    }
                    else
                        value += Integer.parseInt(str);
                }
            }

        }
        else if(ch.equals("]")) {
            // 하나씩 확인
            while(!stack.isEmpty()) {
                String str = stack.pop();
                // 완전한 괄호열
                if(str.equals("[")) {
                    value *= 3;
                    // System.out.println(value);
                    return value;
                }
                if(str.equals("(")) {
                    System.out.println(0);
                    System.exit(0);
                }
                // 숫자인 경우
                else {
                    if(value == 1) {
                        value *= Integer.parseInt(str);
                    }
                    else
                        value += Integer.parseInt(str);
                }
            }
        }
        return -1;
    }
}