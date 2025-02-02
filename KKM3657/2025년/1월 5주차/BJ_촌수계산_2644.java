import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;

class People {
    int curr;
    int parent;
    ArrayList<Integer> child = new ArrayList<>();

    People(int curr) {
        this.curr = curr;
    }
}
public class Main {
    static int N, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 트리 생성
        People[] tree = new People[N+1];
        for(int i=1; i<=N; i++)
            tree[i] = new People(i);

        // 입력
        int E = Integer.parseInt(br.readLine());
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int parentNode = Integer.parseInt(st.nextToken());
            int childNode = Integer.parseInt(st.nextToken());

            tree[parentNode].child.add(childNode);
            tree[childNode].parent = parentNode;
        }

        // BFS 탐색
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        queue.add(new int[]{start,0});
        visited[start] = true;

        while(!queue.isEmpty()) {
            int[] currArr = queue.poll();
            // 현재 위치
            People currPeople = tree[currArr[0]];

            // 도착
            if(currPeople.curr == end) {
                System.out.println(currArr[1]);
                return;
            }
            // 부모로 이동
            if(currPeople.parent != 0 && !visited[currPeople.parent]) {
                visited[currPeople.parent] = true;
                queue.add(new int[]{currPeople.parent, currArr[1]+1});
            }

            // 자식으로 이동
            for(int next : currPeople.child) {
                if(visited[next])
                    continue;
                visited[next] = true;
                queue.add(new int[]{next, currArr[1]+1});
            }
        }
        System.out.println(-1);
    }
}