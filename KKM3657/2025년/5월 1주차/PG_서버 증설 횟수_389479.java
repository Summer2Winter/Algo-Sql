import java.util.ArrayDeque;

class Server {
    int number;
    int end;

    Server(int number, int end) {
        this.number = number;
        this.end = end;
    }
}
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int curr = 0; // 현재 증설된 서버 갯수

        ArrayDeque<Server> queue = new ArrayDeque<>();
        // 서버 인원
        for(int i=0; i<players.length; i++) {
            int player = players[i];

            // 필요한 서버 갯수
            int need = player / m;

            // 만료된 서버 제거
            while(!queue.isEmpty() && queue.peek().end <= i) {
                curr -= queue.poll().number;
            }

            // 증설이 필요한지 확인
            if(curr < need) {
                queue.add(new Server(need-curr, i+k));
                answer += need-curr;
                curr = need;
            }
        }
        return answer;
    }
}