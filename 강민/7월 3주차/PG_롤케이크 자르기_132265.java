class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] typeA = new int[10001], typeB = new int[10001];
        int cnt1 = 0, cnt2 = 0;

        // 전체 가짓수 및 개수 구하기
        for(int i=0; i<topping.length; i++) {
            if(typeA[topping[i]] == 0)
                cnt1++;
            typeA[topping[i]]++;
        }

        // 2분할 시키기
        for(int i=0; i<topping.length; i++) {
            // 기존에서 list로 옮김
            if(typeA[topping[i]] == 1){
                cnt1--;
            }
            typeA[topping[i]]--;

            if(typeB[topping[i]] == 0)
                cnt2++;
            typeB[topping[i]]++;

            //가지수가 같으면 정답
            if(cnt1 == cnt2)
                answer++;
        }
        return answer;
    }
}