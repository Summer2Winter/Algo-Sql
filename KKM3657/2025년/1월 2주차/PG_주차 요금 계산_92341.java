import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

class Solution {
    public int[] solution(int[] fees, String[] records) {

        // map
        Map<String, Integer> park = new HashMap<>();
        Map<String, Integer> timeStamp = new TreeMap<>();

        for(String record : records) {
            // 분할
            String[] recordArr = record.split(" ");
            // 차량번호
            String carNum = recordArr[1];

            // 시간을 분으로 바꾸기
            String[] time = recordArr[0].split(":");
            int minute = (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);
            // 입차
            if(recordArr[2].equals("IN")) {
                park.put(carNum, minute);
            }
            // 출차
            else {
                int inTime = park.get(carNum);
                park.remove(carNum);
                int resultTime = minute - inTime;
                // 기본시간, 기본 요금, 단위 시간, 단위 요금
                // 시간 추가
                if(!timeStamp.containsKey(carNum))
                    timeStamp.put(carNum, resultTime);
                else
                    timeStamp.put(carNum, timeStamp.get(carNum) + resultTime);
            }
        }
        // 입차만 한 차량
        for(Map.Entry<String, Integer> entry : park.entrySet()) {
            String carNum = entry.getKey();
            int minute = 23 * 60 + 59;
            int inTime = entry.getValue();
            int resultTime = minute - inTime;
            // 기본시간, 기본 요금, 단위 시간, 단위 요금

            // 시간 추가
            if(!timeStamp.containsKey(carNum))
                timeStamp.put(carNum, resultTime);
            else
                timeStamp.put(carNum, timeStamp.get(carNum) + resultTime);
        }

        // 금액 계산
        int[] answer = new int[timeStamp.size()];
        int idx = 0;
        for(String carNum : timeStamp.keySet()) {
            // 총 시간
            int resultTime = Math.max(timeStamp.get(carNum) - fees[0], 0);
            // 금액 계산
            int cost = fees[1] + ((int)Math.ceil(1.0 * resultTime / fees[2])) * fees[3];
            answer[idx++] = cost;
        }
        return answer;
    }
}