class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int task = 0, zero = 0;
        while(s.length() != 1) {
            int prevCnt = s.length();
            String temp = s.replaceAll("0", "");
            int currCnt = temp.length();
            // 지운 갯수
            zero += prevCnt - currCnt;
            // 이진 변환
            s = Integer.toString(currCnt, 2);
            task++;
        }
        answer[0] = task;
        answer[1] = zero;
        return answer;
    }
}