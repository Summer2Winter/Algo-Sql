class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {};
        int n = arr.length;
        answer = findAnswer(0, 0, n, arr);
        return answer;
    }
    public int[] findAnswer(int cx, int cy, int size, int[][] arr) {
        // 동일한 숫자 인지 확인
        if(isPossible(cx, cy, size, arr)) {
            int[] result = new int[2];
            result[arr[cx][cy]]++;
            return result;
        }

        int next = size / 2;
        // 4방향 분리
        int[] arr1 = findAnswer(cx, cy, next, arr);
        int[] arr2 = findAnswer(cx, cy+next, next, arr);
        int[] arr3 = findAnswer(cx+next, cy, next, arr);
        int[] arr4 = findAnswer(cx+next, cy+next, next, arr);


        return new int[] {
                arr1[0] + arr2[0] + arr3[0] + arr4[0],
                arr1[1] + arr2[1] + arr3[1] + arr4[1]
        };
    }
    public boolean isPossible(int cx, int cy, int size, int[][] arr) {
        int value = arr[cx][cy];
        // 같은 숫자인지 확인
        for(int i=cx; i<cx+size; i++) {
            for(int j=cy; j<cy+size; j++) {
                if(arr[i][j] != value)
                    return false;
            }
        }
        return true;
    }
}