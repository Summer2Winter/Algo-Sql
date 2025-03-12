import java.util.ArrayList;
class Solution {
    int[] answer;
    int[][] users;
    int[] emoticons;
    int[] percent = new int[]{10,20,30,40};
    ArrayList<Integer> percentList = new ArrayList<>();
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        this.users = users;
        this.emoticons = emoticons;
        selectEmoticons(0);
        return answer;
    }

    public void selectEmoticons(int curr) {
        // 이모티콘 퍼센트 선택 완료
        if(curr == emoticons.length) {
            int[] result = calculateValue();
            // 가입자 수가 많은 경우
            if(result[0] > answer[0]) {
                answer = result;
            }
            else if(result[0] == answer[0] && result[1] > answer[1]) {
                answer = result;
            }
            return;
        }
        // 퍼센트 고르기
        for(int i=0; i<4; i++) {
            // 선택
            percentList.add(percent[i]);
            selectEmoticons(curr+1);
            // 비선택
            percentList.remove(percentList.size()-1);
        }
    }

    public int[] calculateValue() {
        // 계산
        int person = 0;
        int total = 0;
        for(int[] user : users) {
            int money = 0;
            for(int i=0; i<emoticons.length; i++) {
                // 퍼센트를 넘은 이모티콘만 구매
                if(user[0] <= percentList.get(i))
                    money += emoticons[i] - (emoticons[i] * percentList.get(i) / 100);
            }
            // 이모티콘 플러스에 가입 여부
            if(money >= user[1]) {
                person++;
            }
            else {
                total += money;
            }
        }
        return new int[]{person, total};
    }
}