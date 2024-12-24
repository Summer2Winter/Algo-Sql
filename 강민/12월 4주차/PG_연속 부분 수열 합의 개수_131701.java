import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int N = elements.length;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            int sum = 0;
            // 최대 길이 N까지
            for(int length = 0; length < N; length++) {
                sum += elements[(i + length) % N];
                set.add(sum);
            }
        }

        answer = set.size();
        return answer;
    }
}