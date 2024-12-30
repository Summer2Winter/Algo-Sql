import java.util.ArrayList;

class Solution {
    int answer, cnt = 0;
    String[] alpha = new String[]{"A","E","I","O","U"};
    ArrayList<String> list = new ArrayList<>();
    public int solution(String word) {
        // 중복 순열
        selectAlpha(0, word);
        return answer;
    }

    public void selectAlpha(int select, String word) {
        // 문자 변환
        StringBuilder sb = new StringBuilder();
        for(String str : list)
            sb.append(str);

        // 정답인 경우
        if(word.equals(sb.toString()))
            answer = cnt;

        // 다음 사전수
        cnt++;

        // 기저조건
        if(select == 5) {
            return;
        }
        // 추가
        for(int i=0; i<5; i++) {
            // 선택
            list.add(alpha[i]);
            selectAlpha(select+1, word);

            // 비선택
            list.remove(list.size()-1);
        }
    }
}