import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int zero = 0;

        // 입력값
        for(int i=0; i<N; i++) {
            int value = Integer.parseInt(br.readLine());

            if(value == 0)
                zero++;
            else if(value > 0)
                plus.add(value);
            else
                minus.add(value);
        }
        long answer = 0L;
        // 계산
        while(plus.size() > 1) {
            int a = plus.poll(), b = plus.poll();
            // 1이 있는 경우 더하기가 유리
            if(a == 1 || b == 1)
                answer += a + b;
            else
                answer += a * b;
        }

        // 나머지
        while(!plus.isEmpty())
            answer += plus.poll();

        while(minus.size() > 1)
            answer += minus.poll() * minus.poll();

        // 나머지
        while(!minus.isEmpty()) {
            // 0이 없으면 더하기
            if(zero == 0)
                answer += minus.poll();
            else
                minus.poll();
        }
        System.out.println(answer);
    }
}