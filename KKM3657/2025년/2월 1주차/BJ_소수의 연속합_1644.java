import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        // 소수 구하기
        ArrayList<Integer> primeList = findPrime(n);
        // 합 확인
        int sum = 0, j = 0;
        for(int i=0; i<primeList.size(); i++) {
            // 현재 빼기
            if(i != 0)
                sum -= primeList.get(i-1);
            // j이동
            while(j < primeList.size() && sum < n) {
                sum += primeList.get(j++);
            }
            // 합이 n인 경우
            if(sum == n)
                answer++;
        }
        System.out.println(answer);
    }

    public static ArrayList<Integer> findPrime(int n) {
        boolean[] notPrime = new boolean[n + 1];

        // 1은 소수가 아님
        if (n >= 1) notPrime[1] = true;

        // 에라토스테네스의 체
        for (int i = 2; i * i <= n; i++) {
            if (!notPrime[i]) {  // i가 아직 소수인 상태라면
                // i의 배수들을 소수 아님으로 마킹
                for (int j = i * i; j <= n; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        // 결과 수집
        ArrayList<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!notPrime[i]) {
                primeList.add(i);
            }
        }
        return primeList;
    }
}