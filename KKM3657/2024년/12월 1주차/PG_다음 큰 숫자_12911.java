class Solution {
    public int solution(int n) {
        int len = Integer.bitCount(n); // n의 2진수에서 1의 개수를 구함

        int answer = n + 1;
        while (Integer.bitCount(answer) != len) {
            answer++;
        }
        return answer;
    }
}
