import java.util.Queue;
import java.util.PriorityQueue;
import java.util.ArrayList;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        Queue<Integer> pq = new PriorityQueue<>();
        // 시간을 분으로 나타내기
        for(int i=0; i<timetable.length; i++) {
            // 분으로 나타내기
            String[] time = timetable[i].split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = hour * 60 + Integer.parseInt(time[1]);
            pq.add(minute);
        }
        // 9시부터 시작
        int bus = 540;
        int answerTime = 0;
        // 셔틀타기
        for(int num=0; num<n; num++) {
            ArrayList<Integer> list = new ArrayList<>();
            // 남은 자리
            int cnt = m;
            // 버스가 출발하는 시각
            int go = bus + (t * num);
            // 셔틀타기
            int prev = pq.peek();
            while(!pq.isEmpty() && go >= pq.peek()) {
                // 탑승
                if(cnt != 0) {
                    prev = pq.peek();
                    list.add(pq.poll());
                    cnt -= 1;
                }
                // 다 찬 경우
                else
                    break;
            }
            // 자리가 남은 경우
            if(cnt > 0)
                answerTime = go;
            else if(cnt == 0)
                answerTime = prev-1;
        }
        int hour = answerTime / 60;
        int minute = answerTime % 60;

        String hourString = Integer.toString(hour);
        String minuteString = Integer.toString(minute);
        String answerHour = hourString.length() == 1 ? "0"+hourString : hourString;
        String answerMinute = minuteString.length() == 1 ? "0"+minuteString : minuteString;

        answer = answerHour + ":" + answerMinute;
        return answer;
    }
}