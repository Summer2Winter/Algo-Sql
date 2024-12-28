import java.util.ArrayList;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        // 집합
        ArrayList<String> A = new ArrayList<>();
        ArrayList<String> B = new ArrayList<>();

        for(int i=0; i<str1.length()-1; i++) {
            // 글자 분리
            String temp = str1.substring(i,i+2).toUpperCase();
            if(isAlpha(temp))
                A.add(temp);
        }

        for(int i=0; i<str2.length()-1; i++) {
            //글자 분리
            String temp = str2.substring(i,i+2).toUpperCase();
            if(isAlpha(temp))
                B.add(temp);
        }

        // 교집합
        ArrayList<String> sub = new ArrayList<>();
        boolean[] select = new boolean[B.size()];

        for(int i=0; i<A.size(); i++) {
            for(int j=0; j<B.size(); j++) {
                if(select[j])
                    continue;
                // 같은 경우
                if(A.get(i).equals(B.get(j))) {
                    sub.add(B.get(j));
                    select[j] = true;
                    break;
                }
            }
        }
        // 집합의 특징
        int union = A.size() + B.size() - sub.size();

        // 공집합인 경우
        if(union == 0)
            answer = 65536;
        else
            answer = (int)Math.floor((sub.size()*1.0) / union * 65536);

        return answer;
    }
    public boolean isAlpha(String str) {
        char c1 = str.charAt(0), c2 = str.charAt(1);
        if((c1 >= 'A' && c1 <= 'Z' || c1 >= 'a' && c1 <= 'z') &&
                (c2 >= 'A' && c2 <= 'Z' || c2 >= 'a' && c2 <= 'z'))
            return true;
        else
            return false;
    }
}