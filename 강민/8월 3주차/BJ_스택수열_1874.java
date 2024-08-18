import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        // 시작
        for(int i=1; i<=N; i++) {
            stack.push(i);
            sb.append("+\n");
            if(arr[idx] > stack.peek()) {
                continue;
            }
            while(!stack.isEmpty() && arr[idx] == stack.peek()) {
                stack.pop();
                sb.append("-\n");
                idx++;
            }
        }

        if(stack.isEmpty()) {
            System.out.println(sb.toString());
        }
        else
            System.out.println("NO");
    }
}