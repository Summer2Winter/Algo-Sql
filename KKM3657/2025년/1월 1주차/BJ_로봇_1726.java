import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

class Pair {
    int x;
    int y;
    int dir;
    int cnt;

    Pair(int x, int y, int dir, int cnt) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cnt = cnt;
    }
}
public class Main {
    static int N,M;
    static int[][] grid;
    static int[] dx = new int[]{0,0,1,-1}, dy = new int[]{1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 방문 기록
        boolean[][][] visited = new boolean[N][M][4];
        ArrayDeque<Pair> q = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken())-1;
        int sy = Integer.parseInt(st.nextToken())-1;
        int sdir = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken())-1;
        int ey = Integer.parseInt(st.nextToken())-1;
        int edir = Integer.parseInt(st.nextToken())-1;

        q.add(new Pair(sx,sy,sdir,0));
        visited[sx][sy][sdir] = true;

        //BFS
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int dir = curr.dir;
            int cnt = curr.cnt;

            // System.out.println("curr: " + curr.x + " " + curr.y + " " + dir + " " + cnt);
            // 도착지에 도착
            if(curr.x == ex && curr.y == ey && curr.dir == edir) {
                answer = curr.cnt;
                break;
            }

            // 명령 1.
            for(int i=1; i<=3; i++) {
                int nx = curr.x + (i*dx[dir]);
                int ny = curr.y + (i*dy[dir]);

                if(0 > nx || nx >= N || 0 > ny || ny >= M || grid[nx][ny] == 1)
                    break;

                if(!visited[nx][ny][dir]) {
                    visited[nx][ny][dir] = true;
                    q.add(new Pair(nx,ny,dir,cnt+1));
                    // System.out.println("go: " + i + " " + nx + " " + ny + " " + dir + " " + (cnt+1));
                }
            }
            int ndir;
            // 명령 2. 왼쪽
            if(dir == 0) ndir = 3;
            else if(dir == 1) ndir = 2;
            else if(dir == 2) ndir = 0;
            else ndir = 1;

            if(!visited[curr.x][curr.y][ndir]) {
                visited[curr.x][curr.y][ndir] = true;
                q.add(new Pair(curr.x,curr.y,ndir,cnt+1));
                // System.out.println("turn left: " + " " + curr.x + " " + curr.y + " " + ndir + " " + (cnt+1));
            }

            // 명령 2. 오른쪽
            if(dir == 0) ndir = 2;
            else if(dir == 1) ndir = 3;
            else if(dir == 2) ndir = 1;
            else ndir = 0;

            if(!visited[curr.x][curr.y][ndir]) {
                visited[curr.x][curr.y][ndir] = true;
                q.add(new Pair(curr.x,curr.y,ndir,cnt+1));
                // System.out.println("turn right: " + " " + curr.x + " " + curr.y + " " + ndir + " " + (cnt+1));
            }
        }
        System.out.println(answer);
    }
}