import java.io.*;
import java.util.*;

public class Main {

    static class Jewelry implements Comparable<Jewelry> {

        int weight;
        int price;

        Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        public int compareTo(Jewelry o) {
            return o.price - this.price;
        }
    }
    
    static int W, N;

    static StringTokenizer st;
    static int answer;
    
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewelry> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            pq.add(new Jewelry(M, P));
        }

        while (!pq.isEmpty()) {

            Jewelry jewelry = pq.poll();
            int weight = jewelry.weight;
            int price = jewelry.price;

            if (W < weight) {
                answer += price * W;
                break;
            }
            
            answer += price * weight;
            W -= weight;
        }

        System.out.println(answer);
    }
}
