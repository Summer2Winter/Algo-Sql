import java.util.Map;
import java.util.HashMap;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int n = lottos.length;
        // 숫자 넣기
        Map<Integer, Boolean> lotto = new HashMap<>();

        for(int i=0; i<n; i++)
            lotto.put(win_nums[i], true);

        int cnt = 0, zero = 0;
        for(int i=0; i<n; i++) {
            int value = lottos[i];
            if(value == 0)
                zero++;
            if(lotto.containsKey(value))
                cnt++;
        }
        // 등수
        answer[0] = findGrade(cnt+zero);
        answer[1] = findGrade(cnt);
        return answer;
    }
    public int findGrade(int cnt) {
        switch(cnt) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }
}