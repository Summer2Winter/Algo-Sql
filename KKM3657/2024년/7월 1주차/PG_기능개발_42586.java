import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();

        int remain = 100 - progresses[0];
        int time = (int) Math.ceil(remain * 1.0 / speeds[0]), cnt = 1;

        // time 계산
        for(int i=1; i<progresses.length; i++) {
            remain = 100 - progresses[i];
            int temp = (int) Math.ceil(remain * 1.0 / speeds[i]);

            if(time < temp){
                time = temp;
                list.add(cnt);
                cnt = 0;
            }
            cnt++;
        }
        list.add(cnt);
        answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}