class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] number = new int[]{1,2,4};
        // 진법 변환
        while(n != 0) {
            // 1부터 시작하므로 -1하면서 확인
            n--;
            // 나머지
            sb.append(number[n%3]);
            n = n/3;
        }
        return sb.reverse().toString();
    }
}