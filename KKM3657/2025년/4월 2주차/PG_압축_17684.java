import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dict = new HashMap<>();

        // 알파벳 입력
        for(int i=0; i<26; i++) {
            char c = (char)(i + 'A');
            dict.put(Character.toString(c), i+1);
        }
        ArrayList<Integer> answerList = new ArrayList<>();
        int idx = 0, number = 27;
        // 문자열 파싱
        while(idx < msg.length()) {
            int value = -1, dict_idx = -1;
            // 현재 문자 추가
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(idx));

            // 문자열 있는지 확인
            while(idx < msg.length() && dict.containsKey(sb.toString())) {
                dict_idx = dict.get(sb.toString());
                idx++;
                if(idx >= msg.length())
                    break;
                // 다음 문자 추가
                sb.append(msg.charAt(idx));
            }

            // 없으면 추가
            dict.put(sb.toString(), number++);
            answerList.add(dict_idx);
        }
        idx = 0;
        int[] answer = new int[answerList.size()];
        for(Integer temp : answerList) {
            answer[idx++] = temp;
        }
        return answer;
    }
}