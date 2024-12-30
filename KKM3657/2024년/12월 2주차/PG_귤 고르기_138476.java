import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> fruits = new HashMap<>();
        for(int value : tangerine) {
            if(!fruits.containsKey(value))
                fruits.put(value, 1);
            else
                fruits.put(value, fruits.get(value) + 1);
        }

        // 빈도만 리스트에 저장
        List<Integer> count = new ArrayList<>(fruits.values());
        Collections.sort(count, Collections.reverseOrder());

        int idx = 0;
        while(k > 0) {
            k -= count.get(idx++);
            answer++;
        }
        return answer;
    }
}

//import java.util.Map;
//import java.util.HashMap;
//import java.util.Collections;
//import java.util.List;
//import java.util.ArrayList;
//
//class Solution {
//    public int solution(int k, int[] tangerine) {
//        int answer = 0;
//        HashMap<Integer, Integer> fruits = new HashMap<>();
//        for(int value : tangerine) {
//            if(!fruits.containsKey(value))
//                fruits.put(value, 1);
//            else
//                fruits.put(value, fruits.get(value) + 1);
//        }
//
//        // 빈도만 리스트에 저장
//        List<Integer> count = new ArrayList<>(fruits.values());
//        Collections.sort(count, Collections.reverseOrder());
//
//        int idx = 0;
//        while(k > 0) {
//            k -= count.get(idx++);
//            answer++;
//        }
//        return answer;
//    }
//}