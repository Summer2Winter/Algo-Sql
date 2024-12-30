import java.util.Map;
import java.util.HashMap;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> grade = new HashMap<>();

        // 순위 등록
        int idx = 0;
        for(String player : players) {
            grade.put(player, idx++);
        }

        // 순위 변동
        for(String calling : callings) {
            // 호명 선수 등수
            int tempGrade = grade.get(calling);
            // 이전 선수
            String person = players[tempGrade-1];
            // 이전 선수와 교환
            players[tempGrade-1] = calling;
            players[tempGrade] = person;
            // map 인덱스 변경
            grade.put(calling, tempGrade-1);
            grade.put(person, tempGrade);
        }
        answer = players;
        return answer;
    }
}