import java.util.ArrayDeque;
import java.util.HashMap;


class Solution {
    public String[] solution(String[] records) {
        ArrayDeque<String[]> console = new ArrayDeque<>();
        HashMap<String, String> nickname = new HashMap<>();

        // 기록
        for(String record : records) {
            String[] value = record.split(" ");
            String command = value[0], userId = value[1];

            if(command.equals("Enter")) {
                // 들어온 이름
                String name = value[2];
                nickname.put(userId, name);
                console.add(new String[]{userId, "님이 들어왔습니다."});
            }
            else if(command.equals("Leave")) {
                console.add(new String[]{userId, "님이 나갔습니다."});
            }
            else {
                String name = value[2];
                nickname.put(userId, name);
            }
        }
        // 변환
        int idx = 0;
        String[] answer = new String[console.size()];

        while(!console.isEmpty()) {
            String[] recode = console.poll();
            answer[idx++] = nickname.get(recode[0]) + recode[1];
        }
        return answer;
    }
}