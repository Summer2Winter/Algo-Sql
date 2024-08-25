class Solution {
    String value;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int idx = 0;
        for(int i=0; i<numbers.length; i++) {
            value = Long.toString(numbers[i], 2);
            int length = value.length();
            // 높이 계산
            int treeHeight = (int) Math.ceil(Math.log(length + 1) / Math.log(2));
            int fullTreeSize = (int) Math.pow(2, treeHeight) - 1;
            int padding = fullTreeSize - length;

            // 포화 이진트리를 위해 앞에 0을 추가
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < padding; j++) {
                sb.append("0");
            }
            sb.append(value);
            value = sb.toString();
            if(isPossible(0, value.length()-1))
                answer[idx++] = 1;
            else
                answer[idx++] = 0;
        }
        return answer;
    }
    public boolean isPossible(int left, int right) {
        if (left > right) return true;

        int mid = (left + right) / 2;

        // 중간 노드가 0인 경우, 자식이 1이면 안됨
        if (value.charAt(mid) == '0') {
            for (int i = left; i <= right; i++) {
                if (value.charAt(i) == '1') return false;
            }
            return true;
        }

        // 왼쪽과 오른쪽 서브트리 확인
        return isPossible(left, mid - 1) && isPossible(mid + 1, right);
    }
}