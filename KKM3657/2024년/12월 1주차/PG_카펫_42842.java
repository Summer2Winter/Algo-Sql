class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        for(int i=1; i*i<=sum; i++) {
            int j = sum / i;
            if((i-2) * (j-2) == yellow){
                answer[0] = Math.max(i,j);
                answer[1] = Math.min(i,j);
                break;
            }
        }
        return answer;
    }
}