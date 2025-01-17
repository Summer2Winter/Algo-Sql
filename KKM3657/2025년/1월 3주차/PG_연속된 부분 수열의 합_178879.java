class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int n = sequence.length;
        int j = 0, sum = 0, len = Integer.MAX_VALUE;
        // 투포인터
        for(int i=0; i<n; i++) {
            // 빼기
            if(i > 0) {
                sum -= sequence[i-1];
            }
            // j 옮기기
            while(j < n && sum + sequence[j] <= k) {
                // 정답 가능성
                if(sum + sequence[j] == k) {
                    //i부터 j까지
                    int temp = j - i + 1;
                    if(len > temp) {
                        len = temp;
                        answer = new int[]{i,j};
                    }
                }
                sum += sequence[j];
                j++;
            }
        }
        return answer;
    }
}