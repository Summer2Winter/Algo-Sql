import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            long value = Long.parseLong(br.readLine());

            if(value != 0)
                pq.add(value);
            else {
                if(pq.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(pq.poll());
            }
        }
    }
}