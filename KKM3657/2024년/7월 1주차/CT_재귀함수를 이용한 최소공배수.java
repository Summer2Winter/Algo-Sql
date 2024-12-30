import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int value = list.get(0);
        // 최소 공배수 구하기
        for(int i=1; i<N; i++) {
            // 최대공약수 구하기
            int a = Math.max(value, list.get(i));
            int b = Math.min(value, list.get(i));

            int gcdValue = gcd(a,b);
            // 최소공배수 구하기
            value = a*b/gcdValue;
        }
        System.out.println(value);
    }

    public static int gcd(int a, int b) {
        // 최대공약수가 1인 경우
        if(b == 1)
            return 1;
        if(a % b == 0)
            return b;
        else
            return gcd(b, a%b);
    }
}

/*
 GCD를 구하기 위해서 유클리드 호제법을 사용했다
 2개의 자연수 a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면 (단, a>b), a와 b의 최대 공약수는
 b와 r의 최대공약수와 같다.
 최소공배수는 a*b/gcd가 된다.
 */