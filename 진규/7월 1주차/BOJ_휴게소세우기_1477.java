import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, L;
    static int[] area;

    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        area = new int[N+2];
        if (N != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) area[i] = Integer.parseInt(st.nextToken());
        }
        area[0] = 0;
        area[N+1] = L;

        Arrays.sort(area);
        search();
    }

    private static void search() {

        int left = 1, right = L-1; // 문제 조건 : 1 ≤ 휴게소의 위치 ≤ L-1

        while (left <= right) {

            int mid = (left + right) / 2; // 휴게소 거리 차
            int cnt = 0; // 휴게소를 세울 수 있는 개수

            // 휴게소 사이 거리가 mid라고 했을 때, 현재 세워진 휴게소 사이에 새로 끼워 넣을 수 있는 휴게소 수
            for (int i = 1; i < area.length; i++) {
                cnt += (area[i] - area[i-1] - 1) / mid;
            }

            if (cnt > M) left = mid+1; // 너무 많이 휴게소 설치 한 경우
            else right = mid-1; // 너무 적게 휴게소 설치 한 경우
        }

        System.out.println(left);
    }
}