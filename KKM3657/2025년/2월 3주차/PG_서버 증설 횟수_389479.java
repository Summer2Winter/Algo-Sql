import java.util.ArrayDeque;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0, currServer = 0;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for(int i=0; i<players.length; i++) {
            // 필요한 서버수
            int needServer = players[i] / m;

            // 서버가 만료되면 지우기
            if(!queue.isEmpty() && queue.peek()[0] == i) {
                int[] server = queue.poll();
                currServer -= server[1];
            }

            // 서버 추가 증설
            if(needServer > currServer) {
                int newServer = needServer - currServer;
                queue.add(new int[]{i+k, newServer});
                currServer = needServer;
                answer += newServer;
            }
        }
        return answer;
    }
}