import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] people = new int[n+1];
        for (int i = 0; i < m; i++) {
            int person = Integer.parseInt(br.readLine());
            people[person]++;
            if(people[person] >= k) {
                System.out.println(person);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }
}