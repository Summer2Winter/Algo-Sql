import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] grid = new int[20][20];
    static int color = 0;
    static int answerX = Integer.MAX_VALUE, answerY = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 바둑판 그리기
        for(int i=1; i<20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<20; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 바둑판 탐색
        for(int i=1; i<20; i++) {
            for(int j=1; j<20; j++) {
                // 현재 돌
                int curr = grid[i][j];
                if(grid[i][j] == 0)
                    continue;

                int cx = i, cy = j;
                int cnt = 0;
                // 오른쪽 탐색
                while(cx > 0 && cx < 20 && cy > 0 && cy < 20 && grid[cx][cy] == curr) {
                    cnt++;
                    cy += 1;
                }
                // 왼쪽 탐색
                cx = i;
                cy = j-1;
                while(cx > 0 && cx < 20 && cy > 0 && cy < 20 && grid[cx][cy] == curr) {
                    cnt++;
                    cy -= 1;
                }
                changeAnswer(cnt, i ,j);

                cx = i;
                cy = j;
                cnt = 0;
                // 아래 탐색
                while(cx > 0 && cx < 20 && cy > 0 && cy < 20 && grid[cx][cy] == curr) {
                    cnt++;
                    cx += 1;
                }
                cx = i-1;
                cy = j;
                // 위 탐색
                while(cx > 0 && cx < 20 && cy > 0 && cy < 20 && grid[cx][cy] == curr) {
                    cnt++;
                    cx -= 1;
                }
                changeAnswer(cnt, i ,j);

                cx = i;
                cy = j;
                cnt = 0;
                // 대각선 탐색
                while(cx > 0 && cx < 20 && cy > 0 && cy < 20 && grid[cx][cy] == curr) {
                    cnt++;
                    cx += 1;
                    cy += 1;
                }
                cx = i-1;
                cy = j-1;
                // 대각선 탐색
                while(cx > 0 && cx < 20 && cy > 0 && cy < 20 && grid[cx][cy] == curr) {
                    cnt++;
                    cx -= 1;
                    cy -= 1;
                }
                changeAnswer(cnt, i ,j);

                cx = i;
                cy = j;
                cnt = 0;
                // 대각선 탐색
                while(cx > 0 && cx < 20 && cy > 0 && cy < 20 && grid[cx][cy] == curr) {
                    cnt++;
                    cx -= 1;
                    cy += 1;
                }
                cx = i+1;
                cy = j-1;
                // 대각선 탐색
                while(cx > 0 && cx < 20 && cy > 0 && cy < 20 && grid[cx][cy] == curr) {
                    cnt++;
                    cx += 1;
                    cy -= 1;
                }
                changeAnswer(cnt, i ,j);
            }
        }
        if(color != 0) {
            System.out.println(color);
            System.out.println(answerX + " " + answerY);
        }
        else
            System.out.println(0);

    }

    public static void changeAnswer(int cnt, int i, int j) {
        if(cnt == 5) {
            if(answerY > j) {
                color = grid[i][j];
                answerX = i;
                answerY = j;
            }
            else if(answerY == i && answerX > i) {
                color = grid[i][j];
                answerX = i;
                answerY = j;
            }
        }
    }
}