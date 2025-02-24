import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 보석
        PriorityQueue<int[]> jews = new PriorityQueue<>(
                (x,y) -> x[0]==y[0] ? y[1]-x[1] : x[0]-y[0]
        );
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jews.add(new int[]{m,v});
        }

        // 가방
        PriorityQueue<Integer> bag = new PriorityQueue<>();
        for(int i=0; i<k; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }

        // 해당 무게 중에 가장 큰 가치
        PriorityQueue<Integer> temp = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        // 가방에 보석 담기
        while(!bag.isEmpty()) {
            // 가방 꺼내기
            int weight = bag.poll();

            // 무게에 해당하는 보석 꺼내서 또 다른 가방에 넣기
            while(!jews.isEmpty() && jews.peek()[0] <= weight) {
                temp.add(jews.poll()[1]);
            }
            // 그 중에서 제일 가치가 높은거a 뽑기
            if(!temp.isEmpty())
                answer += temp.poll();
        }
        System.out.println(answer);
    }
}