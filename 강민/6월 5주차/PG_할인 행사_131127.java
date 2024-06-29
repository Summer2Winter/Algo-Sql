import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<String, Integer> wantMap = new HashMap<>();
    Map<String, Integer> windowMap = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 원하는 것들
        for(int i=0; i<number.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 슬라이딩 윈도우 초기화
        for(int i=0; i<10; i++) {
            if(windowMap.containsKey(discount[i])) {
                windowMap.put(discount[i], windowMap.get(discount[i]) + 1);
            }
            else {
                windowMap.put(discount[i], 1);
            }
        }
        // for (Map.Entry<String, Integer> entry : windowMap.entrySet()) {
        //         System.out.println("key : " + entry.getKey());
        //         System.out.println("value : " + entry.getValue());
        //     }
        // System.out.println();
        // 1일차를 만족하는 경우
        if(isPossible()) {
            answer += 1;
        }

        for(int i=1; i<discount.length-9; i++) {
            // 개수 변화(추가)
            if(windowMap.containsKey(discount[i+9])) {
                windowMap.put(discount[i+9], windowMap.get(discount[i+9]) + 1);
            }
            else {
                windowMap.put(discount[i+9], 1);
            }
            // 개수 변화(제거)
            windowMap.put(discount[i-1], windowMap.get(discount[i-1]) - 1);

            // 만족 판별
            if(isPossible()){
                answer += 1;
            }

            // for (Map.Entry<String, Integer> entry : windowMap.entrySet()) {
            //     System.out.println("key : " + entry.getKey());
            //     System.out.println("value : " + entry.getValue());
            // }
            // System.out.println();
        }

        return answer;
    }
    public boolean isPossible() {
        for(Map.Entry<String,Integer> entry : wantMap.entrySet()) {
            if(!windowMap.containsKey(entry.getKey()) || windowMap.get(entry.getKey()) != entry.getValue())
                return false;
        }
        return true;
    }
}