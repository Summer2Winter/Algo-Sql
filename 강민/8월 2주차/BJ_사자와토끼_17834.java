import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, E;
    static ArrayList<Integer>[] list;
    static int[] colors;
    static final int RED = 1;
    static final int BLUE = -1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        for(int i=0; i<N; i++) {
            list[i] = new ArrayList<>();
        }
        // 그래프 그리기
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            list[start].add(end);
            list[end].add(start);
        }

        long answer = 0;
        if(isBinaryGraph()) {
            int red = 0;
            int blue = 0;
            for (int i = 0; i < colors.length; i++) {
                if (colors[i] == 1) {
                    red++;
                } else if (colors[i] == -1) {
                    blue++;
                }
            }
            System.out.println(red * blue * 2);
        }
        else
            System.out.println(0);
    }

    public static boolean isBinaryGraph() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        colors = new int[N];
        colors[0] = 1;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : list[cur]) {
                if (colors[next] == 0) {
                    colors[next] = -colors[cur];
                    queue.add(next);
                }
                if (colors[next] == colors[cur]) {
                    return false; // 이분 그래프가 아님
                }
            }
        }
        return true;
    }
}

/* 초기 풀이는 다음과 같다 - 메모리 초과가 나왔다 => 이 문제는 이분그래프 문제로 한개씩 건너서 체크를 하여 나타내면 금방 풀 수 있다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    static int N, E;
    static LinkedList<Integer>[] list;
    static boolean[][] visited, gameover;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new LinkedList[N];
        for(int i=0; i<N; i++) {
            list[i] = new LinkedList<>();
        }
        // 그래프 그리기
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            list[start].add(end);
            list[end].add(start);
        }
        gameover = new boolean[N][N];
        int answer = 0;
        // 게임 실행 - 시작 위치
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                visited = new boolean[N][N];
                visited[i][j] = true;
                if(gameover[i][j])
                    continue;
                if(findAnswer(i,j)) {
                    // System.out.println("(" + i + "," + j + ")");
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean findAnswer(int rabbit, int lion) {
        // 만나는 경우
        if(rabbit == lion) {
            gameover[rabbit][lion] = true;
            return false;
        }
        // 이미 방문처리한 곳은 돌아감
        if(gameover[rabbit][lion])
            return false;

        // 다음지점으로 이동
        for(int i=0; i<list[rabbit].size(); i++) {
            for(int j=0; j<list[lion].size(); j++) {
                int nr = list[rabbit].get(i);
                int nl = list[lion].get(j);
                if(!visited[nr][nl]) {
                    visited[nr][nl] = true;
                    if(!findAnswer(nr, nl)) {
                        gameover[rabbit][lion] = true;
                        return false;
                    }
                }
            }
        }
        return !gameover[rabbit][lion];
    }
}
 */