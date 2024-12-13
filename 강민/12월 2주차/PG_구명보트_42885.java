import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 정렬
        Arrays.sort(people);
        // 무거운 사람부터 옮기기
        int temp = limit;
        int left = 0, right = people.length-1;
        while(left <= right) {
            // 가벼운 사람 무거운 사람 둘다 옮기기
            if(temp-people[left]-people[right] >= 0)
                left++;
            // 무거운 사람만 옮기기
            right--;
            answer++;
        }
        return answer;
    }
}