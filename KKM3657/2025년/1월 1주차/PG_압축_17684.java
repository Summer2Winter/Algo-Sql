import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String msg) {
        // 결과 저장용
        ArrayList<Integer> output = new ArrayList<>();

        // 초기 사전(A~Z)
        HashMap<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            dict.put(String.valueOf(c), i + 1);
        }

        // LZW 압축 로직
        int i = 0;
        int nextCode = 27;

        while (i < msg.length()) {
            int j = i + 1;
            int foundCode = -1; // 마지막으로 사전에 존재했던 코드

            // 사전에 있는 가장 긴 문자열 찾기
            while (j <= msg.length() && dict.containsKey(msg.substring(i, j))) {
                foundCode = dict.get(msg.substring(i, j));
                j++;
            }

            // 찾은 코드값을 결과에 추가
            output.add(foundCode);

            // 사전에 없는 새 문자열 등록: (i~j) 범위
            if (j <= msg.length()) {
                String newEntry = msg.substring(i, j);
                dict.put(newEntry, nextCode++);
            }

            // i를 다음 위치(j-1)로 이동
            i = j - 1;
        }

        // 결과 변환
        int[] answer = new int[output.size()];
        for (int k = 0; k < output.size(); k++) {
            answer[k] = output.get(k);
        }
        return answer;
    }
}
