class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int x = arr1.length, y = arr2[0].length, z = arr1[0].length;
        int[][] answer = new int[x][y];

        for(int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {
                int temp = 0;
                for(int k=0; k<z; k++) {
                    temp += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = temp;
            }
        }
        return answer;
    }
}