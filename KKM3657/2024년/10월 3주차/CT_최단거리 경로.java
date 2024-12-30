import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Node {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

class Distance implements Comparable<Distance> {
    int node;
    int distance;

    Distance(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(Distance d) {
        return this.distance - d.distance;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int t=0; t<E; t++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 양방향 그래프
            graph[s].add(new Node(e,w));
            graph[e].add(new Node(s,w));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 최단거리 배열
        int[] arr = new int[N+1];
        PriorityQueue<Distance> pq = new PriorityQueue<>();
        Arrays.fill(arr, (int)1e9);

        arr[s] = 0;
        pq.add(new Distance(s,0));

        int[] path = new int[N+1];
        // 다익스트라
        while(!pq.isEmpty()) {
            // 노드 뽑기
            Distance curr = pq.poll();
            int node = curr.node;

            // 최단 거리가 불가능한 경우 넘어감
            if(arr[node] < curr.distance)
                continue;

            // 도착지점이면 출력
            if(node == e) {
                System.out.println(arr[e]);
                break;
            }

            // 다음 지점 찾기
            for(int i=0; i<graph[node].size(); i++) {
                Node next = graph[node].get(i);
                int temp = arr[node] + next.weight;

                if(arr[next.end] > temp) {
                    arr[next.end] = temp;
                    pq.add(new Distance(next.end, temp));
                    path[next.end] = node;
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        int x = e;
        while(x != 0) {
            answer.add(x);
            x = path[x];
        }
        for(int i=answer.size()-1; i>=0; i--) {
            System.out.print(answer.get(i) + " ");
        }
    }
}

// 최단 경로 거리는 값이 갱신될때 해당 인덱스에 이전 노드를 기록한 다음에 최단 경로 구하는 것이 완료되면 도착지부터 시작점으로 이동하면 된다.