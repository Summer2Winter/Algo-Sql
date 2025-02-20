class Solution {
    public int solution(String s) {
        int answer = s.length();
        int len = s.length();
        // 문자 길이
        for(int l=1; l<=len/2; l++) {
            StringBuilder sb = new StringBuilder();
            //구간 나누기
            for(int i=0; i<len; i+=l) {
                String curr = s.substring(i,Math.min(i+l, len));
                // 해당 길이가 같을때까지 합치기
                int cnt = 1;
                for(int j=i+l; j<len; j+=l) {
                    String next = s.substring(j,Math.min(j+l, len));
                    if(!curr.equals(next))
                        break;
                    cnt++;
                    i = j;
                }
                if(cnt > 1)
                    sb.append(cnt);
                sb.append(curr);
            }
            // 정답이 되는지 확인
            answer = Math.min(answer, sb.toString().length());
        }
        return answer;
    }
}