import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        ArrayList<int[]> orange = new ArrayList<>();
        // 귤 정렬
        Arrays.sort(tangerine);
        int temp = -1;

        // 귤 갯수 파악하기
        for(int i=0; i<tangerine.length; i++) {
            // 새로운 종류
            if(tangerine[i] != temp) {
                orange.add(new int[]{1,tangerine[i]});
                temp = tangerine[i];
            }
            // 기존 종류
            else {
                int[] arr = orange.get(orange.size()-1);
                arr[0] += 1;
            }
        }

        // 개수로 정렬
        Collections.sort(orange, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });

        int idx = 0;
        // 최소 종류 구하기
        while(k > 0) {
            k -= orange.get(idx)[0];
            answer++;
            idx++;
        }
        // for(int i=0; i<orange.size(); i++)
        //     System.out.println("사이즈: " + orange.get(i)[1] + " 크기: " + orange.get(i)[0]);

        return answer;
    }
}