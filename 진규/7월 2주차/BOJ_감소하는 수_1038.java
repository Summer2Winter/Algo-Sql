import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;

    static StringTokenizer st;
    static List<Long> numList; // 감소하는 수가 담긴 리스트

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        numList = new ArrayList<>();

        if (N < 10) System.out.println(N); // 0 ~ 9는 그대로 출력
        else if (N >= 1023) System.out.println(-1); // 최대 감소하는 수 9876543210은 1022번째 숫자, 그 이상 초과하면 -1 출력
        else {
            for (int i = 0; i < 10; i++) {

                isDecreasingNum(i, 1);
            }

            Collections.sort(numList);
            System.out.println(numList.get(N));
        }
    }

    private static void isDecreasingNum(long num, int idx) { // num : 현재 수, idx 자릿 수

        if (idx > 10) return;

        numList.add(num);

        // num % 10의 수보다 작아야 계속 감소하는 수 찾는 과정 진행
        for (int i = 0; i < num % 10; i++) {

            isDecreasingNum((num * 10) + i, idx + 1);
        }
    }
}