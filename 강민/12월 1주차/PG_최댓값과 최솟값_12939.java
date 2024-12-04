import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        while(st.hasMoreTokens()){
            int value = Integer.parseInt(st.nextToken());
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        answer = answer + min + " " + max;
        return answer;
    }
}