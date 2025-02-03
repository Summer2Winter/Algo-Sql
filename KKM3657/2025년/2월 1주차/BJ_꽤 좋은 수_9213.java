import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] dividSum = new int[1000001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전체 약수 구하기
        for(int i=1; i<=1000000; i++) {
            for(int j=i*2; j<=1000000; j+=i)
                dividSum[j] += i;
        }
        int test = 1;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int badness = Integer.parseInt(st.nextToken());

            if(start == 0 && end == 0 && badness == 0)
                break;

            int result = query(start, end, badness);
            System.out.printf("Test %d: %d\n", test++, result);
        }
    }

    public static int query(int start, int end, int badness) {
        int cnt = 0;
        for(int i=start; i<=end; i++) {
            if(Math.abs(dividSum[i] - i) <= badness)
                cnt++;
        }

        return cnt;
    }
}