/*
    import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int value1 = Integer.parseInt(st.nextToken());
        int value2 = Integer.parseInt(st.nextToken());
        int value3 = Integer.parseInt(st.nextToken());

        ArrayList<Long> list = new ArrayList<>();
        HashSet<Long> set = new HashSet<>();

        long answer;
        if(value2 == 1) {
            // value2가 1인 경우, 바로 value1 % value3 결과를 반환
            answer = value1 % value3;
        } else {
            // 초기화
            long temp = value1 % value3; // value1의 첫 번째 나머지를 초기값으로 설정
            long n = value2;

            // 반복해서 나머지 값을 구하고, 중복된 나머지가 발생하면 주기 탐색
            while(n > 0 && !set.contains(temp)) {
                set.add(temp);        // 나머지를 set에 추가
                list.add(temp);       // 나머지를 list에 추가
                temp = (temp * value1) % value3; // 다음 나머지 계산
                n--;
            }

            // 주기가 발생했을 때 남은 횟수를 주기 길이로 나눠서 처리
            int remain = (value2 - 1) % list.size();
            answer = list.get(remain);  // 주기 안에서 나머지를 찾음
        }
        System.out.println(answer);
    }
}

 */
