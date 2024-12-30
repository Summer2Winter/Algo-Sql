import java.util.Arrays;
import java.util.*;

class Plan{
    String name;
    String[] start;
    String[] end;
    int time;

    Plan(String name, String[] start, String[] end, int time){
        this.name = name;
        this.start = start;
        this.end = end;
        this.time = time;
    }
}

class Solution {
    public static String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        // 시작 시간으로 정렬
        Arrays.sort(plans, (x,y) -> {
            int time1 = Integer.parseInt(x[1].replace(":", ""));
            int time2 = Integer.parseInt(y[1].replace(":", ""));
            return time1 - time2;
        });

        //1.시작 시간 확인
        //2.끝나는 시간 확인 -> idx 고정, 끝나는 시간 변수
        //3.다음 과제의 시작 시간 확인 => 끝나는 시간보다 빠르다? 스택에 넣기 남은 시간, 제목 넣고 다음 과제 수행
        //4.다음 과제의 시작 시간 확인 => 끝나는 시간보다 느리다? 정답에 넣고, 끝나는 시간 기준으로 스택에서 뽑기

        ArrayDeque<Plan> stack = new ArrayDeque<>();
        int idx = 0;

        for(int i=0; i<plans.length; i++){
            // 기존 일이 다 끝난 경우 현재 일 진행
            if(!stack.isEmpty()) {
                // 스택에서 뽑기
                Plan prev = stack.pop();
                // 현재 일
                String currN = plans[i][0];
                String[] currS = plans[i][1].split(":");
                int ct = (Integer.parseInt(currS[1]) + Integer.parseInt(currS[0]) * 60);
                int pt = (Integer.parseInt(prev.end[1]) + Integer.parseInt(prev.end[0]) * 60);
                int flag = ct - pt;

                // 기존 과제가 바로 끝나는  경우
                if(flag == 0){
                    // 정답에 추가
                    answer[idx++] = prev.name;
                }
                // 기존 과제가 늦게 끝나는 경우
                else if(flag < 0){
                    // 남은 시간 계산후 stack에 넣기
                    int ps = (Integer.parseInt(prev.start[1]) + Integer.parseInt(prev.start[0]) * 60);
                    int sub = ct - ps;

                    prev.start = currS;
                    prev.time -= sub;

                    int minute = Integer.parseInt(prev.start[1]) + prev.time;
                    prev.end[1] = String.valueOf(minute%60);
                    int hour = Integer.parseInt(prev.start[0]) + (minute/60);
                    prev.end[0] = String.valueOf(hour);
                    stack.push(prev);
                }
                // 기존 과제보다 빨리 끝나는 경우
                else{
                    // 정답에 추가 후 남은 과제 하나 뽑아서 시간 줄이기
                    answer[idx++] = prev.name;
                    // 추가로 일할 수 있는 시간 계산
                    int sub = ct - pt;

                    while(stack.size() != 0) {
                        Plan temp = stack.peek();
                        // 일하다가 중간에 새로운 일이 들어온 경우
                        int value = temp.time - sub;
                        if(value > 0){
                            temp.time = value;
                            temp.start = currS;

                            int minute = Integer.parseInt(currS[0]) + temp.time;
                            temp.end[0] = String.valueOf(minute%60);
                            int hour = Integer.parseInt(currS[1]) + (minute/60);
                            temp.end[1] = String.valueOf(hour);
                            break;
                        }
                        else if(value == 0){
                            answer[idx++] = stack.pop().name;
                            break;
                        }
                        else{
                            answer[idx++] = stack.pop().name;
                            sub = -(value);
                        }
                    }
                }
            }
            // 최신 과제 갱신 후 스택에 넣기
            int time = Integer.parseInt(plans[i][2]);
            String[] start = plans[i][1].split(":");
            String[] end = new String[2];

            int minute = Integer.parseInt(start[1]) + time;
            end[1] = String.valueOf(minute%60);
            int hour = Integer.parseInt(start[0]) + (minute/60);
            end[0] = String.valueOf(hour);

            stack.push(new Plan(plans[i][0], start, end, time));
        }
        // 스택에서 남은 과제 수행
        while(!stack.empty())
            answer[idx++] = stack.pop().name;
        return answer;
    }
}