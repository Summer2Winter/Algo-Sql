class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        // 같은 부모를 만나는 경우는 /2를 계속해서 몫이 같은경우
        while(a != b) {
            answer++;
            a = (a+1) / 2;
            b = (b+1) / 2;
        }
        return answer;
    }
}