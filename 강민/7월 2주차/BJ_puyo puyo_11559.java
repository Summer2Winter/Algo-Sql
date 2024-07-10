import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] grid = new char[12][6];
    static int cnt;
    static char ch;
    static boolean[][] visited1, visited2;
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));

        // 지도 그리기
        for(int i=0; i<12; i++) {
            String str = br.readLine();
            for(int j=0; j<6; j++) {
                grid[i][j] = str.charAt(j);
            }
        }
        int answer = 0;
        // 뿌요뿌요
        while(true) {
            boolean flag = false;
            visited1 = new boolean[12][6];
            visited2 = new boolean[12][6];
            // 터트릴 뿌요뿌요 탐색 후 4개 이상이면 삭제 처리
            for(int i=0; i<12; i++) {
                for(int j=0; j<6; j++) {
                    cnt = 1;
                    if(grid[i][j] == '.' || visited1[i][j])
                        continue;
                    visited1[i][j] = true;
                    findPyo(i,j);

                    if(cnt >= 4){
                        flag = true;
                        visited2[i][j] = true;
                        ch = grid[i][j];
                        grid[i][j] = '.';
                        delectPyo(i,j);
                    }
                }
            }
            if(!flag) {
                break;
            }
            answer++;

            // 뿌요뿌요 옮기기
            char[][] temp = new char[12][6];
            for(int i=0; i<12; i++)
                Arrays.fill(temp[i], '.');

            for(int j=0; j<6; j++) {
                int idx = 11;
                for(int i=11; i>=0; i--) {
                    if(grid[i][j] != '.') {
                        temp[idx--][j] = grid[i][j];
                    }
                }
            }
            grid = temp;
        }
        System.out.println(answer);
    }
    public static void findPyo(int cx, int cy) {
        for(int i=0; i<4; i++) {
            int nx = cx + dx[i], ny = cy + dy[i];

            if(0 > nx || nx >= 12 || 0 > ny || ny >=6)
                continue;

            if(grid[cx][cy] == grid[nx][ny] && !visited1[nx][ny]) {
                visited1[nx][ny] = true;
                cnt++;
                findPyo(nx,ny);
            }
        }
    }
    public static void delectPyo(int cx, int cy) {
        for(int i=0; i<4; i++) {
            int nx = cx + dx[i], ny = cy + dy[i];

            if(0 > nx || nx >= 12 || 0 > ny || ny >=6)
                continue;

            if(ch == grid[nx][ny] && !visited2[nx][ny]) {
                visited2[nx][ny] = true;
                grid[nx][ny] = '.';
                delectPyo(nx,ny);
            }
        }
    }
}