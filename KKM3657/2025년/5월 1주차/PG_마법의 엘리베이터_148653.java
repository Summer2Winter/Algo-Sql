class Solution {
    public int solution(int storey) {
        int answer = findAnswer(storey, 0);
        return answer;
    }

    public int findAnswer(int storey, int cnt) {
        // 기저조건
        if(storey == 0) {
            return cnt;
        }
        // 현재위치
        int curr = storey % 10;
        // 다음위치
        int next = (storey / 10) % 10;

        // 밑으로 이동
        if(curr < 5) {
            return findAnswer(storey / 10, cnt + curr);
        }
        // 위로 이동
        else if(curr > 5) {
            return findAnswer((storey/10)+1, cnt + (10-curr));
        }
        // 5이면 윗자리 확인
        else {
            // 윗자리도 5이상이면 올리기
            if(next >= 5)
                return findAnswer((storey/10)+1, cnt + (10-curr));
            else
                return findAnswer(storey / 10, cnt + curr);
        }
    }
}

// 반복문
class Solution {
    public int solution(int storey) {
        int answer = 0;

        while(storey > 0) {
            // 현재위치
            int curr = storey % 10;
            // 다음위치
            int next = (storey / 10) % 10;

            // 밑으로 이동
            if(curr < 5) {
                answer += curr;
                storey = storey / 10;
            }
            // 위로 이동
            else if(curr > 5) {
                answer += 10 - curr;
                storey = (storey/10) + 1;
            }
            // 5이면 윗자리 확인
            else {
                // 윗자리도 5이상이면 올리기
                if(next >= 5) {
                    answer += 10 - curr;
                    storey = (storey/10) + 1;
                }
                else {
                    answer += curr;
                    storey = storey / 10;
                }
            }
        }
        return answer;
    }
}