import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, N = truck_weights.length;
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        int bridgeWeight = 0, idx = 0, pass = 0;
        // 0으로 채움
        for(int i=0; i<bridge_length; i++)
            bridge.add(0);
        // 다리 건너기
        while(pass < N) {
            // 1. 다리에서 나오기
            if(!bridge.isEmpty()) {
                int truck = bridge.poll();
                if(truck > 0)
                    pass++;
                bridgeWeight -= truck;
            }

            // 2. 다리에 트럭이 올라갈 수 있는지 확인
            if(idx < N && bridgeWeight + truck_weights[idx] <= weight) {
                bridge.add(truck_weights[idx]);
                bridgeWeight += truck_weights[idx];
                idx++;
            }
            else
                bridge.add(0);
            answer++;
        }
        return answer;
    }
}