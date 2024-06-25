import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;

    static StringTokenizer st;
    static int[] time;

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[100000+1];
        for (int i = 0; i < 100000+1; i++) time[i] = -1;

        bfs();

        System.out.println(time[K]);
    }

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        time[N] = 0;

        while (!queue.isEmpty()) {

            int[] qPoll = queue.poll();
            int v = qPoll[0];
            int step = qPoll[1];

            if (v == K) break;

            if (2*v <= 100000 && time[2*v] == -1) {

                time[2*v] = step;
                queue.add(new int[]{2*v, step});
            }
            if (0 <= v-1 && time[v-1] == -1) {

                time[v-1] = step+1;
                queue.add(new int[]{v-1, step+1});
            }
            if (v+1 <= 100000 && time[v+1] == -1) {

                time[v+1] = step+1;
                queue.add(new int[]{v+1, step+1});
            }
        }
    }
}