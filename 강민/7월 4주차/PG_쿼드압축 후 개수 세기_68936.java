class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {};
        answer = findSolution(arr, arr.length, arr.length, arr.length);
        return answer;
    }

    public int[] findSolution(int[][] arr, int cx, int cy, int temp) {
        //기저 조건
        if(temp == 1) {
            if(arr[cx-1][cy-1] == 1) {
                return new int[]{0,1};
            }
            else
                return new int[]{1,0};
        }

        temp /= 2;

        //왼쪽 상단
        int[] arr1 = findSolution(arr, cx-temp, cy-temp, temp);
        int[] arr2 = findSolution(arr, cx-temp, cy, temp);
        int[] arr3 = findSolution(arr, cx, cy-temp, temp);
        int[] arr4 = findSolution(arr, cx, cy, temp);

        if(arr1[0] == arr2[0] && arr2[0] == arr3[0] && arr3[0] == arr4[0] &&
                arr1[1] == arr2[1] && arr2[1] == arr3[1] && arr3[1] == arr4[1]) {
            if ((arr1[0] == 0 && arr1[1] == 1) || (arr1[0] == 1 && arr1[1] == 0))
                return arr1;
            else {
                arr1[0] += arr2[0] + arr3[0] + arr4[0];
                arr1[1] += arr2[1] + arr3[1] + arr4[1];
                return arr1;
            }
        }
        else {
            arr1[0] += arr2[0] + arr3[0] + arr4[0];
            arr1[1] += arr2[1] + arr3[1] + arr4[1];
            return arr1;
        }
    }
}

//class Solution {
//    int[] answer = new int[2];
//    public int[] solution(int[][] arr) {
//        int x = arr.length;
//        find_answer(arr, x, x, x);
//        return answer;
//    }
//
//    public void find_answer(int[][] arr, int x, int y, int cnt){
//        // 합칠수 있는지 판별
//        if(isPossible(arr, x, y, cnt)){
//            answer[arr[x-cnt][y-cnt]]++;
//            return;
//        }
//        int value = cnt / 2;
//        int nx = x, ny = y;
//        // 왼쪽 상단으로 이동
//        find_answer(arr, nx-value, ny-value, value);
//        // 오른쪽 상단으로 이동
//        find_answer(arr, nx, ny-value, value);
//        // 왼쪽 하단으로 이동
//        find_answer(arr, nx-value, ny, value);
//        // 오른쪽 하단으로 이동
//        find_answer(arr, nx, ny, value);
//    }
//
//    public boolean isPossible(int[][]arr, int x, int y, int cnt){
//        int value = arr[x-cnt][y-cnt];
//        for(int i=x-cnt; i<x; i++){
//            for(int j=y-cnt; j<y; j++){
//                if(value != arr[i][j])
//                    return false;
//            }
//        }
//        return true;
//    }
//}