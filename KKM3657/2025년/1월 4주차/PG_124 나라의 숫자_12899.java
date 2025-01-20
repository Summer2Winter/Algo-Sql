class Solution {
    public String solution(int n) {
        int[] number = new int[]{1, 2, 4};
        StringBuilder sb = new StringBuilder();

        // n이 0이 될 때까지 3으로 나누며 변환
        while (n > 0) {
            n--; // 0-indexed로 맞추기 위해 n-1 처리
            int remainder = n % 3;
            sb.append(number[remainder]); // 나머지를 number 배열로 매핑
            n /= 3; // n을 갱신
        }

        return sb.reverse().toString(); // 뒤집어서 반환
    }
}
