import java.util.HashSet;

class Solution {
    int total = 0;
    HashSet<Integer> set = new HashSet<>();
    public int solution(int[] elements) {
        int answer = 0;
        for(int i=0; i<elements.length; i++)
            total += elements[i];
        set.add(total);

        // 연속 수열 시작 지점 선택
        for(int i=0; i<elements.length; i++) {
            makeSubset(i, elements);
        }
        answer = set.size();
        return answer;
    }
    public void makeSubset(int start, int[] elements) {
        // 슬라이딩 윈도우
        int value = 0, size = elements.length;
        int left = start, right = start;
        while(right != (start + size -1) % size) {
            value += elements[right];
            set.add(value);
            set.add(total-value);
            right = (right+1) % size;
        }
    }
}