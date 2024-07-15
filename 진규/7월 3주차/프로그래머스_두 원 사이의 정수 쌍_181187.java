/*
    원의 방정식 이용
*/

class Solution {
    public long solution(int r1, int r2) {
        
        long answer = 0;
        
        for (int i = 1; i <= r2; i++) {
            
            double up = Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));
            double down = Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2));

            answer += ((long)Math.floor(up) - (long)Math.ceil(down) + 1);
        }
        
        return answer * 4;
    }
}