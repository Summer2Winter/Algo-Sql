import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] num;

    static StringTokenizer st;
    static int answer;

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num); // 이분 탐색 전제조건

        for (int i = 0; i < N; i++) {

            isGoodNum(i);
        }

        System.out.println(answer);
    }

    private static void isGoodNum(int idx) {

        int left = 0;
        int right = N-1;
        int target = num[idx];

        while (left < right) {

            if (num[left] + num[right] == target) {

                if (left != idx && right != idx) { // 목표 숫자와 투 포인터가 안 겹치는 경우에 +1
                    answer += 1;
                    break;
                }

                // "수의 위치가 다르면 값이 같아도 다른 수이다." 조건 때문에 작성
                else if (left == idx) left += 1;
                else if (right == idx) right -= 1;
            }

            if (num[left] + num[right] < target) left += 1;
            else if (num[left] + num[right] > target) right -= 1;
        }
    }
}