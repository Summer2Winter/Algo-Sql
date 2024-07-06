import java.util.*;

/*
    문제 그림 자체가 재귀를 뜻하고 있음.
    10%가 1원 미만일 때 까지 재귀
*/
class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    static int[] answer;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        answer = new int[enroll.length];
        
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i); // map[참가자 이름] : 참가자 번호
        }
        
        for (int i = 0; i < seller.length; i++) {
            
            int idx = map.get(seller[i]); // 돈 번 사람의 번호
            int money = amount[i] * 100; // 돈 번 사람 금액
            answer[idx] += money; 
            
            // 10%식 부모에게 분배하면서 (돈이 1원 미만일 때 or 부모 없을 때) 까지 분배
            spread(money, enroll, referral, idx);
        }
        
        return answer;
    }
    
    private static void spread(int money, String[] enroll, String[] referral, int idx) {

        money *= 0.1;
        if (money < 1) return; // 돈이 1원 미만인 경우 return
        
        String parentName = referral[idx]; // 부모 이름
        if (parentName.equals("-")) {
            answer[idx] -= money; // 민호(center)에게 줘야하니깐 자식 돈 삭제
            return; // 부모 없는 경우 return
        }
        
        int parentIdx = map.get(parentName); // 부모 번호
        
        answer[idx] -= money; // 자식 돈 삭제
        answer[parentIdx] += money; // 부모 돈 더하기
        
        spread(money, enroll, referral, parentIdx);
    }
}