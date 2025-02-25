import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr); // 배열 정렬

        long minDiff = Long.MAX_VALUE;
        long[] answer = new long[3];

        // 3개가 있어야 용액을 만들 수 있음
        for(int i=0; i<n-2; i++) {
            int left = i+1;
            int right = n-1;

            while(left < right) {
                long sum = arr[i] + arr[left] + arr[right];

                // 0에 가까운 값을 찾음
                if(Math.abs(sum) < minDiff) {
                    minDiff = Math.abs(sum);
                    answer[0] = arr[i];
                    answer[1] = arr[left];
                    answer[2] = arr[right];
                }

                // 0보다 작으면 left 이동
                if (sum < 0) {
                    left++;
                }
                // 0보다 크면 right 이동
                else {
                    right--;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}