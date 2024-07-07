/*
    [1, -1, 1...] 혹은 [-1, 1, -1...]을 계속 곱하면서 최댓값 찾기
    이때, 정답이 0 미만은 절대 될 수 없으므로 0 미만인 경우 0으로 만들기 
*/

class Solution {
    public long solution(int[] sequence) {
        
        long answer = 0;
        boolean isPlus = true;
        
        long purse1 = 0;
        long purse2 = 0;
        
        for (int i = 0; i < sequence.length; i++) {
            
            int num = sequence[i];
            purse1 += isPlus ? num : -num;
            purse2 += isPlus ? -num : num;
            
            purse1 = Math.max(0, purse1);
            purse2 = Math.max(0, purse2);
            
            answer = Math.max(answer, Math.max(purse1, purse2));
            
            isPlus = !isPlus;
        }
        
        return answer;
    }
}