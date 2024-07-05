import java.util.*;

class Solution {
    
    static class Work implements Comparable<Work> {
    
        String name;
        int start;
        int playTime;
        
        Work(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
        
        public int compareTo(Work o) {
            return this.start - o.start;
        }
        
        public String toString() {
            return name + " " + start + " " + playTime;
        }
    }
    
    static PriorityQueue<Work> pq = new PriorityQueue<>();
    static Stack<Work> stack = new Stack<>(); // 대기중인 목록
    static Deque<Work> q = new LinkedList<>(); // 현재 작업중인 목록
    static String[] answer;
    
    public String[] solution(String[][] plans) {
        
        answer = new String[plans.length];
        
        for(int i = 0; i < plans.length; i++) {
            
            String n = plans[i][0];
            int s = calculateTime(plans[i][1]);
            int p = Integer.parseInt(plans[i][2]);
            
            pq.add(new Work(n, s, p));
        }
        
        int now = 0;
        int idx = 0;
        while (!pq.isEmpty() || !stack.isEmpty()) {
            
            // 현재 작업중인 과제가 없는 경우 -> 과제 채우기
            if (q.isEmpty()) {
                if (pq.isEmpty()) // 새로운 과제에 없고, 대기 목록이 있다면 대기열에서 뽑기
                    q.add(stack.pop());
                else if (stack.isEmpty()) { // 새로운 과제에 있고, 대기 목록이 없다면 새로운 과제에서 시작
                    Work t = pq.poll();
                    now = t.start;
                    q.add(t);
                }
                else { // 새로운 과제, 대기 목록 둘다 있으면
                    if (now >= pq.peek().start)
                        q.add(pq.poll());
                    else
                        q.add(stack.pop());
                }
            }
            
            else {
                // 새로운 과제가 없거나, 지금 작업을 완료해도 다음 작업 시작시간 안된 경우
                if (pq.isEmpty() || now + q.peek().playTime <= pq.peek().start) {
                    Work w = q.poll();
                    answer[idx++] = w.name;
                    now += w.playTime;
                }
                else {
                    Work w = q.poll();
                    w.playTime -= (pq.peek().start - now);
                    stack.add(w);
                    now = pq.peek().start;
                }
            }
        }
        
        answer[idx] = q.poll().name;
        return answer;
    }
    
    private static int calculateTime(String time) { // "12:30" -> 12*60+30=750 형태로 전환
        String[] t = time.split(":");
        int minute = Integer.parseInt(t[0]) * 60;
        int second = Integer.parseInt(t[1]);
        
        return minute + second;
    }
}