import java.io.*;
import java.util.*;

public class Main {

    static int N, M, S, T;
    static List<Integer>[] graph;
    static List<Integer>[] graphR;
    static boolean[] fromT, fromS, toT, toS;
    
    static StringTokenizer st;
    static int answer;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        graphR = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            
            graph[i] = new ArrayList<>();
            graphR[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graphR[b].add(a);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());        

        fromS = new boolean[N+1];
        fromS[T] = true; // 도착지 방문 했는데 계속 이동하는 경우 방지
        fromT = new boolean[N+1];
        fromT[S] = true; // 출발지 방문 했는데 계속 이동하는 경우 방지

        toT = new boolean[N+1];
        toS = new boolean[N+1];
        dfs(S, graph, fromS);
        dfs(T, graph, fromT);
        dfs(S, graphR, toS);
        dfs(T, graphR, toT);
        
        for (int i = 1; i < N+1; i++) {

            if (fromS[i] && fromT[i] && toS[i] && toT[i]) answer += 1;
        }

        System.out.println(answer - 2); // S, T를 뺀 값
    }

    private static void dfs(int now, List<Integer>[] list, boolean[] check) {

        if (check[now]) return;
        check[now] = true;

        for (int next : list[now]) {

            dfs(next, list, check);
        }
    }
}