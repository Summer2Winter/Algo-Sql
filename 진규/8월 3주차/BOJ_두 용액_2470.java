import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    static StringTokenizer st;
    static int maxValue = Integer.MAX_VALUE;
    static int[] answer;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        answer = new int[2];
        int lp = 0, rp = N-1;
        while (lp < rp) {

            int mid = arr[lp] + arr[rp];

            int absValue = Math.abs(mid);
            if (absValue < maxValue) {
                maxValue = absValue;
                answer[0] = arr[lp];
                answer[1] = arr[rp];
            }

            if (mid <= 0) {
                lp += 1;
            }
            else if (mid > 0) {
                rp -= 1;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}