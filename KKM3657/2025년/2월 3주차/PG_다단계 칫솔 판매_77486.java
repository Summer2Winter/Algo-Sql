import java.util.Map;
import java.util.HashMap;
class Member {
    String parent;
    String name;
    int money;

    Member(String parent, String name) {
        this.parent = parent;
        this.name = name;
    }
}
class Solution {
    HashMap<String, Member> people = new HashMap<>();;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 등록
        for(int i=0; i<enroll.length; i++)
            people.put(enroll[i], new Member(referral[i], enroll[i]));

        // 판매
        for(int i=0; i<seller.length; i++) {
            // 금액처리
            makeSell(seller[i], amount[i]*100);
        }

        int[] answer = new int[enroll.length];
        int idx = 0;
        for(String name : enroll) {
            answer[idx++] = people.get(name).money;
        }
        return answer;
    }

    public void makeSell(String curr, int money) {
        // 금액이 0이면 불가능, 루트이면 반환
        if(money == 0 || curr.equals("-"))
            return;

        // 공재후 자기 금액 저장
        Member currMember = people.get(curr);

        // 10프로 금액
        int pay = money / 10;
        currMember.money += (money - pay);

        // 상납
        makeSell(currMember.parent, pay);
    }
}