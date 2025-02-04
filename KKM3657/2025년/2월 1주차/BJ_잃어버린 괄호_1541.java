import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, "+-", true);

        ArrayDeque<String> stack = new ArrayDeque<>();
        while(st.hasMoreTokens()) {
            String curr = st.nextToken();
            // +,- 이면 push
            if(curr.equals("+") || curr.equals("-"))
                stack.push(curr);
                // 숫자일 경우
            else {
                // 비어 있으면 push
                if(stack.isEmpty())
                    stack.push(curr);
                else {
                    // 최상단이 + 이면 더해서 push
                    if(stack.peek().equals("+")) {
                        String opcode = stack.pop(); // +
                        String number = stack.pop(); // 숫자
                        int value = Integer.parseInt(number) + Integer.parseInt(curr);
                        stack.push(Integer.toString(value));
                    }
                    // 최상단이 - 이면 바로 push
                    else {
                        stack.push(curr);
                    }
                }
            }
        }
        // System.out.println(stack.toString());
        // 순서대로 계산하기
        int answer = Integer.parseInt(stack.pollLast());
        while(!stack.isEmpty()) {
            String temp = stack.pollLast();
            if(temp.equals("-"))
                continue;
            answer -= Integer.parseInt(temp);

        }
        System.out.println(answer);
    }
}

//// 방법2.
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.StringTokenizer;
//import java.util.ArrayDeque;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String input = br.readLine();
//        StringTokenizer plus = new StringTokenizer(input, "-");
//
//        ArrayDeque<Integer> queue = new ArrayDeque<>();
//        while(plus.hasMoreTokens()) {
//            // + 계산
//            String[] number = plus.nextToken().split("\\+");
//            if(number.length == 1)
//                queue.add(Integer.parseInt(number[0]));
//            else {
//                int sum = 0;
//                for(String value : number) {
//                    sum += Integer.parseInt(value);
//                }
//                // 계산
//                queue.add(sum);
//            }
//        }
//        // 순서대로 계산하기
//        int answer = queue.pollFirst();
//        while(!queue.isEmpty()) {
//            answer -= queue.pollFirst();
//        }
//        System.out.println(answer);
//    }
//}