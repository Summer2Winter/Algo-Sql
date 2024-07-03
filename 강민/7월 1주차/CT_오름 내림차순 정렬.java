import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(arr);
        for(int i=0; i<N; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        // 내림차순 정렬
        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2, Collections.reverseOrder());

        for(int i=0; i<N; i++)
            System.out.print(arr2[i] + " ");
        System.out.println();
    }
}

// 오름차순 => Arrays.sort(arr);
// int[] 를 Integer[] => Arrays.stream(arr).boxed().toArray(Integer[]::new);
// 내림차순 => Arrays.sort(arr, Collections.reverseOrder());
// String 정렬 => char[]로 변환후 sort / char[] arr = str.toCharArray(); String str = new  String(arr);