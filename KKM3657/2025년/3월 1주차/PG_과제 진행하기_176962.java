import java.util.Arrays;
import java.util.ArrayDeque;
class Plan {
    String name;
    int remain;

    Plan(String name, int remain) {
        this.name = name;
        this.remain = remain;
    }
}
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        // 시간 순 정렬
        Arrays.sort(plans, (x,y) -> x[1].compareTo(y[1]));

        ArrayDeque<Plan> stack = new ArrayDeque<>();
        int idx = 0, time = convertTime(plans[0][1]);
        stack.push(new Plan(plans[0][0], Integer.parseInt(plans[0][2])));

        for(int i=1; i<plans.length; i++) {
            // 진입시간
            int enter = convertTime(plans[i][1]);

            // 남은시간
            int remain = enter - time;

            // 남은 시간과 비교
            while(!stack.isEmpty() && remain > 0) {
                // 현재 작업
                Plan curr = stack.peek();
                int canWorkTime = remain - curr.remain;
                // 작업 수행
                if(canWorkTime >= 0) {
                    stack.pop();
                    answer[idx++] = curr.name;
                    remain -= curr.remain;
                    time += curr.remain;
                }
                // 작업이 남는 경우
                else {
                    curr.remain = -canWorkTime;
                    time += remain;
                    remain = 0;
                }
            }

            // 작업 추가하기
            stack.push(new Plan(plans[i][0], Integer.parseInt(plans[i][2])));
            time = enter;
        }
        // 남은 과목
        while(!stack.isEmpty()) {
            answer[idx++] = stack.pop().name;
        }
        return answer;
    }

    public int convertTime(String time) {
        String[] str = time.split(":");
        return 60 * Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
    }
}