import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

class Node {
    int value;
    int idx;

    Node(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Node> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            list.add(new Node(Integer.parseInt(st.nextToken()), i));
        }

        // Collections.sort(list, new Comparator<Node>() {
        //     @Override
        //     public int compare(Node a, Node b) {
        //         return a.value - b.value;
        //     }
        // });

        Collections.sort(list, Comparator.comparing(node -> node.value));

        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            // 원래 자리
            int idx = list.get(i).idx;
            answer[idx] = i+1;
        }

        for(int i=0; i<N; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}