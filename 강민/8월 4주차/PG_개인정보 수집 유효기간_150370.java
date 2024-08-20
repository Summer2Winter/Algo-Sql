import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    Map<String, Integer> termParse = new HashMap<>();
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();

        // 오늘 날짜 파싱
        String[] todayDate = today.split("\\.");
        int year = Integer.parseInt(todayDate[0]);
        int month = Integer.parseInt(todayDate[1]);
        int day = Integer.parseInt(todayDate[2]);

        // 약관 문자열 파싱
        for(String term : terms) {
            String[] termValue = term.split(" ");
            termParse.put(termValue[0], Integer.parseInt(termValue[1]));
        }

        // 약관 파기
        int idx = 1;
        for(String privacy : privacies) {
            String[] privacyValue = privacy.split(" ");

            String[] date = privacyValue[0].split("\\.");
            int dateYear = Integer.parseInt(date[0]);
            int dateMonth = Integer.parseInt(date[1]);
            int dateDay = Integer.parseInt(date[2]);

            // 날짜 계산
            int tempMonth = dateMonth + termParse.get(privacyValue[1]);
            int totalMonth = tempMonth % 12;
            if(totalMonth == 0) {
                totalMonth = 12;
                dateYear--;
            }
            int totalYear = (tempMonth / 12) + dateYear;
            System.out.println(year + " " + month + " " + day);
            System.out.println(totalYear + " " + totalMonth + " " + dateDay);

            // 파기하는 경우
            if(year > totalYear)
                list.add(idx);
            else if(year == totalYear) {
                if(month > totalMonth)
                    list.add(idx);
                else if(month == totalMonth){
                    if(day > dateDay)
                        list.add(idx);
                    else if(day == dateDay)
                        list.add(idx);
                }
            }
            idx++;
        }
        Collections.sort(list);
        answer = new int[list.size()];
        idx = 0;
        for(Integer value : list)
            answer[idx++] = value;
        return answer;
    }
}