class Solution {
    int answer, targetNumber;
    public int solution(int[] numbers, int target) {

        targetNumber = target;
        // 재귀
        targetFind(0,0,numbers);

        return answer;
    }
    public void targetFind(int curr, int value, int[] numbers) {
        // 기저조건
        if(curr == numbers.length) {
            if(value == targetNumber)
                answer++;
            return;
        }

        // 더하기
        targetFind(curr+1, value + numbers[curr], numbers);

        // 빼기
        targetFind(curr+1, value - numbers[curr], numbers);
    }
}