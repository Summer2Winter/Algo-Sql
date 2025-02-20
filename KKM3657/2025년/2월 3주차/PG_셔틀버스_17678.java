import java.util.PriorityQueue;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Integer> people = new PriorityQueue<>();

        // 대기열 등록
        for(String person : timetable) {
            String[] time = person.split(":");
            int minute = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            people.add(minute);
        }

        int result = 0;
        // 차량 운행
        for(int i=0; i<n; i++) {
            int busTime = (i * t) + 540; // 출발 시간
            int remain = m; // 남은 자리

            // 버스 탑승
            while(!people.isEmpty() && remain > 0 && busTime >= people.peek()) {
                result = people.poll();
                remain--;
            }

            // 마지막 차량
            if(i == n-1) {
                if(remain > 0) result = busTime;
                else if(remain == 0) result -= 1;

                // 시간 변환
                answer = String.format("%02d:%02d", result / 60, result % 60);
            }
        }
        return answer;
    }
}