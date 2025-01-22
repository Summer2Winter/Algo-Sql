import java.util.HashSet;

class Solution {
    HashSet<HashSet<String>> set = new HashSet<>();
    HashSet<String> currentSet = new HashSet<>();
    String[] user_id_arr, banned_id_arr;
    boolean[] selected;
    int answer;
    public int solution(String[] user_id, String[] banned_id) {
        user_id_arr = user_id;
        banned_id_arr = banned_id;
        selected = new boolean[user_id.length];
        // 고르기
        findAnswer(0);
        answer = set.size();
        return answer;
    }

    public void findAnswer(int select) {
        // 기저조건
        if(select == banned_id_arr.length) {
            answer++;
            set.add(new HashSet<>(currentSet));
            return;
        }

        // 고르기
        for(int i=0; i<user_id_arr.length; i++) {
            if(selected[i])
                continue;
            // 정규 표현식
            String regex = banned_id_arr[select].replace("*", ".");
            if(user_id_arr[i].matches(regex)) {
                selected[i] = true;
                currentSet.add(user_id_arr[i]);
                findAnswer(select + 1);
                currentSet.remove(user_id_arr[i]);
                selected[i] = false;
            }
        }
    }
}