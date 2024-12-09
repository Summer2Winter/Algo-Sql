import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        // 2의 나머지가 나오는 횟수가 최소가 되면 된다.
        while(n > 0) {
            if(n % 2 != 0)
                ans++;
            n /= 2;
        }
        return ans;
    }
}