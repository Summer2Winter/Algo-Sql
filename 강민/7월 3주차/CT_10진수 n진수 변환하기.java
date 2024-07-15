import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        char[] arr = value.toCharArray();
        int answer = 0;
        for(int i=0; i<arr.length; i++) {
            answer = answer * 2 + ((int) arr[i] - '0');
        }
        System.out.println(answer);
    }
}

/*
    num = num * n + binary[i]; 식을 만족한다
    자리수가 증가하면 n이 전 자리수에 곱해지므로 곱하기 n이 된다.
    반대로 10진수 수를 N진수로 바꾸려면
    String tmp = Integer.toString(i, n)
    n진수를 10진수로 바꾸는 법은
    int answer = Integer.parseInt(i,n);
*/