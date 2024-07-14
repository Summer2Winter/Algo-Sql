
/*
    거리가 d 이하인 x, y좌표 정수의 개수
    피타고라스 정리에서 y^2 = x^2 - d^2
    최대 y좌표의 거리에서 k만큼 나누게 된다면 거리 d이하의 좌표 개수를 알 수 있게 됨 
*/

class Solution {
    public long solution(int k, int d) {
        
        long answer = 0;
        
        for (int i = 0; i <= d; i+=k) {
            
            int maxY = pythagoras(i, d);
            answer += (maxY / k) + 1;
        }
        
        return answer;
    }
    
    private int pythagoras(int x, int d) {
        
        long xx = (long)Math.pow(x, 2);
        long dd = (long)Math.pow(d, 2);
        
        return (int)Math.sqrt(dd - xx);
    }   
}