class Solution {
    public int solution(String name) {
        int answer = Integer.MAX_VALUE;
        int len = name.length();
        int upDown = 0;
        for(int i=0; i<len; i++) {
            // 상하 구하기
            upDown += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 좌우 구하기
            int idx = i+1;
            // 연속된 A개수 구하기
            while(idx < len && name.charAt(idx) == 'A')
                idx++;
            // 오른쪽으로 갔다가 다시 왼쪽으로 오는경우
            answer = Math.min(answer, i * 2 + (len - idx));
            // 왼쪽으로 갔다가 다시 오른쪽으로 오는경우
            answer = Math.min(answer, (len - idx) * 2 + i);
        }
        answer += upDown;
        return answer;
    }
}