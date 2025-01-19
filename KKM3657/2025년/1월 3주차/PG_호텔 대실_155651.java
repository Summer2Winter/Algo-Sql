import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        // 입장 시간 순으로 정렬
        Arrays.sort(book_time, new Comparator<String[]>() {
            @Override
            public int compare(String[] x, String[] y) {
                String x0 = x[0].replace(":", ""), x1 = x[1].replace(":", "");
                String y0 = y[0].replace(":", ""), y1 = y[1].replace(":", "");

                // 시작 시간 순으로 정렬
                return x0.equals(y0) ? x1.compareTo(y1) : x0.compareTo(y0);
            }
        });

        // 우선순위 큐
        PriorityQueue<Integer> room = new PriorityQueue<>();

        for(int i=0; i<book_time.length; i++) {
            String[] arr1 = book_time[i][0].split(":");
            String[] arr2 = book_time[i][1].split(":");
            int enter = Integer.parseInt(arr1[0]) * 60 + Integer.parseInt(arr1[1]);
            int finsh = Integer.parseInt(arr2[0]) * 60 + Integer.parseInt(arr2[1]);
            // 빈 객실 확인
            if(!room.isEmpty() && room.peek() + 10 <= enter) {
                room.poll();
            }
            // 회의실 배정
            room.add(finsh);
            // 객실 수 확인
            answer = Math.max(answer, room.size());
        }
        return answer;
    }
}