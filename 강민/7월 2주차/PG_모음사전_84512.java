// 중복순열
import java.util.ArrayList;

class Solution {
    int answer = 0, curr = 0;
    ArrayList<String> list = new ArrayList<>();
    String[] letter = new String[]{"A", "E", "I", "O", "U"};
    public int solution(String word) {
        findAnswer(word);
        return answer;
    }
    public void findAnswer(String word) {
        // 확인
        if(list.size() == word.length()) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<list.size(); i++)
                sb.append(list.get(i));
            if(word.equals(sb.toString())){
                answer = curr;
            }
        }

        if(list.size() > 4)
            return;

        for(int i=0; i<5; i++) {
            // 단어 추가
            curr++;
            list.add(letter[i]);
            findAnswer(word);

            // 단어 선택 안하고 넘어감
            list.remove(list.size()-1);
        }
    }
}