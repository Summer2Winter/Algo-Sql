import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    int answer = 0;
    int[] arr;
    ArrayList<Integer> list = new ArrayList<>();
    public int solution(String[][] clothes) {
        Map<String, HashSet<String>> map = new HashMap<>();

        // 분류하기
        for(String[] thing : clothes) {
            String category = thing[1];

            HashSet<String> name;
            if(map.containsKey(category)) {
                name = map.get(category);
            }
            else{
                name = new HashSet<>();
            }
            name.add(thing[0]);
            map.put(category, name);
        }
        int temp = 1;
        for(Map.Entry<String, HashSet<String>> entry: map.entrySet()) {
            temp *= (entry.getValue().size()+1);
        }
        // 고르는 갯수
        answer += temp;
        return answer - 1;
    }
}

/*
규칙을 못찾아서 부분집합으로 해결하려고 했지만 N = 30인 관계로 타임 아웃
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    int answer = 0;
    int[] arr;
    ArrayList<Integer> list = new ArrayList<>();
    public int solution(String[][] clothes) {
        Map<String, HashSet<String>> map = new HashMap<>();

        // 분류하기
        for(String[] thing : clothes) {
            String category = thing[1];

            HashSet<String> name;
            if(map.containsKey(category)) {
                name = map.get(category);
            }
            else{
                name = new HashSet<>();
            }
            name.add(thing[0]);
            map.put(category, name);
        }

        // 배열 채우기
        arr = new int[map.size()];
        int idx = 0;
        for(Map.Entry<String, HashSet<String>> entry: map.entrySet()) {
            arr[idx++] = entry.getValue().size();
        }
        // 고르는 갯수
        makeSubset(0);
        return answer;
    }
    public void makeSubset(int curr) {
        // 선택완료
        if(curr >= arr.length) {
            int temp = 1;
            if(list.isEmpty())
                temp = 0;
            for(int i=0; i<list.size(); i++)
                temp *= arr[list.get(i)];
            answer += temp;
            return;
        }

        // 선택
        list.add(curr);
        makeSubset(curr+1);

        // 비선택
        list.remove(list.size()-1);
        makeSubset(curr+1);
    }
}
 */