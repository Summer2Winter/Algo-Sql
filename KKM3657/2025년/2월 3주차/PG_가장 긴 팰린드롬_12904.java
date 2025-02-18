class Solution {
    public int solution(String s) {
        int answer = 1;

        //투 포인터
        for(int i=0; i<s.length(); i++) {
            char a = s.charAt(i);
            for(int j=s.length()-1; j>=i; j--) {
                if(a != s.charAt(j))
                    continue;
                // 같은 경우 팰린드롬 확인
                if(isPossible(i,j,s)) {
                    answer = Math.max(answer,j-i+1);
                    break;
                }
            }
        }
        return answer;
    }
    public boolean isPossible(int start, int end, String s) {
        int len = end-start+1;
        int idx = 0;
        while(idx < len/2) {
            if(s.charAt(start+idx) != s.charAt(end-idx))
                return false;
            idx++;
        }
        return true;
    }
}