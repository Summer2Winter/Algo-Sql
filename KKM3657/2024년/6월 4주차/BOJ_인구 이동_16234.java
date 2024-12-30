import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, L, R, value, answer = 0;
    static int[][] A, temp; // 나라 인원, 임시 배열
    static boolean[][] visited; // 방문 기록
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    // DFS로 열린 국경선 탐색, 열린 국경선은 같은 영역으로 표시
    public static void dfs(int x, int y, int cnt){
        for(int i=0; i<4; i++) {    // 4방향 탐색
            int nx = x + dx[i], ny = y + dy[i]; // 다음 지점
            if(0 > nx || nx >= N || 0 > ny || ny >= N)  // 격자점 외부이면 넘어감
                continue;
            int abs = Math.abs(A[x][y] - A[nx][ny]);    // 국경선 공유 판별
            if(!visited[nx][ny] && L <= abs && abs <= R){
                visited[nx][ny] = true;
                temp[nx][ny] = cnt; // 같은 영역
                dfs(nx, ny, cnt);   // 다음 지점 이동
            }
        }
    }
    // 공유된 국경선에 총 인원과 땅을 구하여 value 계산
    public static void bfs(int x, int y, int cnt){
        int total_p = A[x][y], total_g = 1; // 처음 시작점
        // 초기화
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x,y});
        // 큐가 빌때까지 반복
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i=0; i<4; i++) {    // 4방향 탐색
                int nx = curr[0] + dx[i], ny = curr[1] + dy[i]; // 다음 지점
                if(0 > nx || nx >= N || 0 > ny || ny >= N)  // 격자점 외부이면 넘어감
                    continue;
                if(!visited[nx][ny] && temp[nx][ny] == cnt){    // 같은 영역이면 계산
                    total_g++;
                    total_p += A[nx][ny];
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        // 영역이 1개이면 넘어감
        if(total_p != A[x][y]) {
            value = total_p / total_g;  // 가치 계산
            for (int i = 0; i < N; i++) {   // 가치 갱신
                for (int j = 0; j < N; j++) {
                    if (temp[i][j] == cnt)
                        A[i][j] = value;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        // 입력
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        value = -1;
        // 인구 이동 반복
        while(value != 0){
            value = 0;
            int cnt = 1;    // 같은 영역인지 확인하기 위한 변수
            visited = new boolean[N][N];    // 방문 기록 초기화
            temp = new int[N][N];   // 임시 배열
            for(int i=0; i<N; i++) {    // 국경선 공유 탐색 시작
                for(int j=0; j<N; j++) {
                    if(visited[i][j])
                        continue;
                    visited[i][j] = true;
                    temp[i][j] = cnt;
                    dfs(i,j,cnt);
                    cnt++;
                }
            }
            // 인구 이동 계산
            cnt = 1;
            visited = new boolean[N][N];    // 방문 기록 초기화
            for(int i=0; i<N; i++) {    // 인구 이동 탐색 시작
                for(int j=0; j<N; j++) {
                    if(visited[i][j])
                        continue;
                    bfs(i, j, cnt);
                    cnt++;
                }
            }
            answer++;   // 일수
        }
        System.out.println(answer-1);
    }
}