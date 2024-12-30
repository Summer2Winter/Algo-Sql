import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, idx = 0;    // 트럭 인덱스
        Queue<Integer> bridge = new ArrayDeque<>();

        for(int i=0; i<bridge_length; i++)  // 다리를 0으로 채움
            bridge.add(0);

        while(!bridge.isEmpty()) {   // 다리가 빌때까지 반복
            weight += bridge.poll();    // 다리에서 트럭이 나옴

            if(idx < truck_weights.length) { // 모든 트럭이 다리를 지나가는지 확인
                if(weight >= truck_weights[idx]) {   // 다리가 견딜 수 있으면 트럭 진입
                    weight -= truck_weights[idx];   // 다리 위에 올라가 있는 트럭 무게
                    bridge.add(truck_weights[idx]); // 다리에 트럭 진입
                    idx++;  // 다음 트럭
                }
                else {
                    bridge.add(0);  // 무게를 견디지 못하면 공백으로 처리
                }
            }
            answer++;   // 초 추가
        }
        return answer;
    }
}