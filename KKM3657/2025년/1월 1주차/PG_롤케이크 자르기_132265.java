import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();

        int sizeA = 0, sizeB = 0;
        // 추가
        for(int value : topping) {
            // 이미 있는 경우 갱신
            if(mapB.containsKey(value))
                mapB.put(value, mapB.get(value)+1);
                // 없으면 가짓수 +1
            else {
                sizeB++;
                mapB.put(value, 1);
            }
        }
        // 2분할
        for(int value : topping) {
            //A에 추가
            if(mapA.containsKey(value))
                mapA.put(value, mapA.get(value)+1);
            else {
                sizeA++;
                mapA.put(value, 1);
            }

            //B에서 제거
            if(mapB.containsKey(value)) {
                if(mapB.get(value) == 1)
                    sizeB--;
                mapB.put(value, mapB.get(value)-1);
            }

            //정답인 경우
            if(sizeA == sizeB)
                answer++;
        }
        return answer;
    }
}

// 시간 복잡도 줄이기
/*
class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        int[] A = new int[10001], B = new int[10001];

        int sizeA = 0, sizeB = 0;
        // 추가
        for(int value : topping) {
            // 이미 있는 경우 가짓수 +1
            if(B[value] == 0)
                sizeB++;
            B[value]++;
        }

        // 2분할
        for(int value : topping) {
            //A에 추가
            if(A[value] == 0)
                sizeA++;
            A[value]++;

            //B에서 제거
            if(B[value] == 1)
                sizeB--;
            B[value]--;

            //정답인 경우
            if(sizeA == sizeB)
                answer++;
        }
        return answer;
    }
}
 */