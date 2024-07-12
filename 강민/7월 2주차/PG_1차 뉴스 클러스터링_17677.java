import java.util.ArrayList;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        // 문자열 파싱
        ArrayList<String> str1List = parseString(str1);
        ArrayList<String> str2List = parseString(str2);

        if(str1List.isEmpty() && str2List.isEmpty()) {
            return 65536;
        }

        // 자카드 유사도 - 교집합
        int size2 = 0;
        boolean[] select1 = new boolean[str1List.size()];
        boolean[] select2 = new boolean[str2List.size()];

        for(int i=0; i<str1List.size(); i++) {
            for(int j=0; j<str2List.size(); j++) {
                if(select2[j] || !str1List.get(i).equals(str2List.get(j)))
                    continue;
                select2[j] = true;
                size2++;
                break;
            }
        }

        // 자카드 유사도 - 합집합
        int size1 = str1List.size() + str2List.size() - size2;

        double temp = size2 / (size1*1.0);
        System.out.println(size1 + " " + size2+ " " + temp);
        answer = (int) (temp * 65536);
        return answer;
    }
    public ArrayList<String> parseString(String str) {
        ArrayList<String> strList = new ArrayList<>();

        for(int i=0; i<str.length()-1; i++) {
            char c1 = str.charAt(i), c2 = str.charAt(i+1);
            if((c1 >= 'a' && c1 <= 'z' || c1 >= 'A' && c1 <= 'Z')
                    && (c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z')) {
                // System.out.println(str.substring(i,i+2));
                String value = str.substring(i,i+2);
                strList.add(value.toUpperCase());
                // System.out.print(value.toUpperCase() + " ");
            }
        }
        // System.out.println();
        return strList;
    }
}