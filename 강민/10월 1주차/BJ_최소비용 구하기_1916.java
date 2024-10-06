import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

class Node {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
class Distance {
    int node;
    int distance;

    Distance(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 그리기
        for(int e=0; e<E; e++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end,weight));
        }

        // 시작점, 도착점
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        // 다익스트라
        int[] distance = new int[N+1];
        Arrays.fill(distance, (int)1e9);
        distance[start] = 0;

        PriorityQueue<Distance> pq = new PriorityQueue<>((x,y) -> {
            return x.distance - y.distance;
        });
        pq.add(new Distance(start, 0));

        while(!pq.isEmpty()) {
            // 최단거리 뽑기
            Distance curr = pq.poll();

            // 최단거리가 될 수 없는 경우 넘어감
            if(distance[curr.node] < curr.distance)
                continue;

            // 목표점에 도달한 경우 종료
            if(curr.node == end)
                break;

            for(int i=0; i<graph[curr.node].size(); i++) {
                // 연결된 노드에서 최솟값 갱신
                Node node = graph[curr.node].get(i);
                int temp = distance[curr.node] + node.weight;

                if(distance[node.end] > temp) {
                    distance[node.end] = temp;
                    pq.add(new Distance(node.end, temp));
                }
            }
        }

        System.out.println(distance[end]);
    }
}