import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String value = Integer.toString(n,k);
        StringTokenizer st = new StringTokenizer(value, "0");
        int answer = 0;
        while(st.hasMoreTokens()) {
            long number = Long.parseLong(st.nextToken());
            if(isPrime(number))
                answer++;
        }
        return answer;
    }
    public boolean isPrime(long value) {
        if(value <= 1)
            return false;
        else if(value == 2)
            return true;
        else if(value % 2 == 0)
            return false;
        else {
            for(long i=3; i*i<=value; i+=2) {
                if(value % i == 0)
                    return false;
            }
            return true;
        }
    }
}