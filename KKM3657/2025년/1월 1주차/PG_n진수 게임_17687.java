class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int curr = 0, value = 0, cnt = 0;
        // 전체
        while(true) {
            // 숫자
            String number = Integer.toString(value, n);

            // 전체 개수 만큼 반복
            for(int i=0; i<number.length(); i++) {
                // 현재 시점
                if(curr == p-1) {
                    sb.append(Character.toString(number.charAt(i)).toUpperCase());
                    cnt++;
                }
                curr = (curr + 1) % m;
                if(cnt == t) {
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
            value++;
        }
        return sb.toString();
    }
}