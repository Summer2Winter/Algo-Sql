import java.io.*;
import java.util.*;

public class Main {
    static char[][] grid;
    static int N;
    static ArrayList<int[]> space = new ArrayList<>();
    static ArrayList<int[]> teachers = new ArrayList<>();
    static int[] dx = new int[]{0,1,0,-1}, dy = new int[]{1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                grid[i][j] = st.nextToken().charAt(0);
                // 빈칸
                if(grid[i][j] == 'X') {
                    space.add(new int[]{i,j});
                }
                else if(grid[i][j] == 'T') {
                    teachers.add(new int[]{i,j});
                }
            }
        }
        // 빈칸 3개 선택
        selectWall(0,0);
        System.out.println("NO");
    }
    public static void selectWall(int curr, int select) {
        // 선택 완료
        if(select == 3) {
            // 가능 여부 확인
            if(isPossible()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }
        // 넘어가는 경우
        if(curr >= space.size())
            return;
        // 선택, 마킹
        int[] currnetSpace = space.get(curr);
        grid[currnetSpace[0]][currnetSpace[1]] = 'W';
        // 다음 넘어감
        selectWall(curr+1, select+1);

        // 선택 안함
        grid[currnetSpace[0]][currnetSpace[1]] = 'X';
        selectWall(curr+1, select);
    }
    public static boolean isPossible() {
        // 선생님에서 4방향 탐색
        for(int[] teacher : teachers) {
            // 4방향 확인
            for(int i=0; i<4; i++) {
                int cx = teacher[0], cy = teacher[1];
                while(0 <= cx && cx < N && 0 <= cy && cy < N) {
                    // 학생을 만나면 불가능
                    if(grid[cx][cy] == 'S')
                        return false;
                    else if(grid[cx][cy] == 'W')
                        break;
                    cx = cx + dx[i];
                    cy = cy + dy[i];
                }
            }
        }
        return true;
    }
}