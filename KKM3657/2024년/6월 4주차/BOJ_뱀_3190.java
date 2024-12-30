import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Command {
    int t;
    char dir;

    Command(int t, char dir) {
        this.t = t;
        this.dir = dir;
    }
}
public class Main {
    static int N, time = 0;
    static int[][] grid;
    static int[] dx = new int[]{-1,0,1,0}, dy = new int[]{0,1,0,-1};
    static LinkedList<Pair> bug = new LinkedList<>();
    static Queue<Command> command = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];
        int apple = Integer.parseInt(br.readLine());

        // 사과 위치
        for(int i=0; i<apple; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            grid[x][y] = 2;
        }

        int c = Integer.parseInt(br.readLine());
        // 명령어
        for(int i=0; i<c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            command.add(new Command(t,dir));
        }

        // 초기 위치 추가
        grid[0][0] = 1;
        bug.add(new Pair(0,0));
        int d = 1; // 오른쪽

        while(true) {
            // 뱀 머리 부분 이동
            Pair head = bug.get(0);
            int nx = head.x + dx[d];
            int ny = head.y + dy[d];

            time++;
            // 게임 종료
            if(nx < 0 || nx >= N || ny < 0 || ny >= N || grid[nx][ny] == 1) {
                System.out.println(time);
                System.exit(0);
            }
            // 머리 이동
            bug.addFirst(new Pair(nx,ny));

            // 꼬리 이동
            if(grid[nx][ny] != 2) {
                Pair curr = bug.remove(bug.size() - 1);
                grid[curr.x][curr.y] = 0;
            }
            grid[nx][ny] = 1;

            // 명령어 확인
            if(!command.isEmpty() && time == command.peek().t) {
                Command curr = command.poll();
                // 오른쪽 회전
                if(curr.dir == 'D') {
                    d = (d + 1) % 4;
                }
                else {
                    d = (d + 3) % 4;
                }
            }
        }
    }
}