import java.util.HashSet;

class Solution {
    int N;
    String[][] relation;
    // 전체 집합
    HashSet<HashSet<Integer>> keySet = new HashSet<>();
    public int solution(String[][] relation) {
        int answer = 0;
        this.relation = relation;
        N = relation[0].length;
        // 키에 대한 부분집합 만들기
        makeSubSet(0, new HashSet<>());
        answer = keySet.size();
        return answer;
    }
    public void makeSubSet(int curr, HashSet<Integer> set) {
        // 키 선택 완료
        if(curr >= N) {
            // 최소성 확인
            for(HashSet<Integer> temp : keySet) {
                // 뽑은 집합이 원소로 포함되어 있으면 안됨(set이 더 큰 집합)
                if(set.containsAll(temp))
                    return;
            }
            // 유일성 확인
            if(isPossible(set)) {
                keySet.add(new HashSet<>(set));
            }
            return;
        }

        // 비선택 -> 최소성을 확인하기 위해 작은거부터 시작
        makeSubSet(curr+1, new HashSet<>(set));

        // 선택
        set.add(curr);
        makeSubSet(curr+1, new HashSet<>(set));
    }
    public boolean isPossible(HashSet<Integer> set) {
        // 유일성
        HashSet<String> key = new HashSet<>();

        // "A,B,C" 와 "A,C,B"는 다른것이기 때문에 Set을 사용하면 안됨
        for(String[] str : relation) {
            StringBuilder sb = new StringBuilder();
            for(Integer idx : set) {
                sb.append(str[idx]).append(",");
            }
            if(key.contains(sb.toString()))
                return false;
            key.add(sb.toString());
        }
        return true;
    }
}