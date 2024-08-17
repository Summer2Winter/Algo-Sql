import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, B;
    static int[][] board;
    static int minH = Integer.MAX_VALUE, maxH = Integer.MIN_VALUE;
    static int minTime = Integer.MAX_VALUE;

    static StringTokenizer st;
    static int[] answer;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(board[i][j], minH);
                maxH = Math.max(board[i][j], maxH);
            }
        }

        answer = new int[2];
        // 평평하게 만들려는 height는 minH <= height <= maxH에서 형성됨
        // O(N * M * (0 <= 땅의 높이 <= 256))
        for (int height = maxH; height >= minH; height--) {
            int time = 0; // 시간
            int inventory = B; // 블록 여분

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    if (board[i][j] > height) { // 현재 층이 목표로 한 높이보다 높다면 빼기
                        time += (board[i][j] - height) * 2;
                        inventory += (board[i][j] - height);
                    }
                    else if (board[i][j] < height) { // 현재 층이 목표로 한 높이보다 낮다면 쌓기
                        time += (height - board[i][j]);
                        inventory -= (height - board[i][j]);
                    }
                }
            }

            // 평평하게 만들기가 불가능한 경우
            if (inventory < 0) continue;

            // 최소 시간, 최대 높이를 구하기 때문에 시간 확인
            if (time < minTime) {
                minTime = time;
                answer[0] = time;
                answer[1] = height;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}