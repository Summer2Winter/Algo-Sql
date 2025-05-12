import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = new int[]{-1,0,1,0}, dy = new int[]{0,1,0,-1};

        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        int cx = N/2, cy = N/2;
        arr[cx][cy] = 1;
        int value = 2, dir = 0, step = 1;
        int answerX = 0, answerY = 0;

        if (target == 1) {
            answerX = cx + 1;
            answerY = cy + 1;
        }

        // N^2까지 반복
        while (value <= N*N) {
            // 같은 step을 두 방향에 사용
            for (int rep = 0; rep < 2 && value <= N*N; rep++) {
                for (int i = 0; i < step && value <= N*N; i++) {
                    cx += dx[dir];
                    cy += dy[dir];
                    arr[cx][cy] = value++;
                    if(arr[cx][cy] == target) {
                        answerX = cx+1;
                        answerY = cy+1;
                    }
                }
                dir = (dir + 1) % 4;
            }
            step++;
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println(answerX + " " + answerY);
    }
}