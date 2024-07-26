import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Genre implements Comparable<Genre> {
    int total;
    PriorityQueue<int[]> musicList;

    Genre(int total, PriorityQueue<int[]> musicList) {
        this.total = total;
        this.musicList = musicList;
    }

    @Override
    public int compareTo(Genre g) {
        return g.total - this.total;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Genre> album = new HashMap<String, Genre>();

        for(int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            //데이터 반영
            if(!album.containsKey(genre)){
                PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        return a[0] == b[0] ? a[1]-b[1] : b[0]-a[0];
                    }
                });
                pq.add(new int[]{play, i});
                Genre temp = new Genre(play, pq);
                album.put(genre, temp);
            }
            // 이미 있는 경우
            else {
                Genre temp = album.get(genre);
                PriorityQueue<int[]> pq = temp.musicList;

                // 총 노래 추가
                temp.total += play;
                // 음악 추가
                pq.add(new int[]{play, i});
                album.put(genre, temp);
            }
        }
        List<Genre> list = new ArrayList<>(album.values());
        Collections.sort(list);

        ArrayList<Integer> answerList = new ArrayList<>();
        for(Genre temp : list) {
            PriorityQueue<int[]> pq = temp.musicList;
            if(pq.size() != 1) {
                for(int i=0; i<2; i++) {
                    int[] music = pq.poll();
                    answerList.add(music[1]);
                    System.out.println(music[1]);
                }
            }
            else {
                int[] music = pq.poll();
                answerList.add(music[1]);
                System.out.println(music[1]);
            }
        }

        answer = answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        // int idx = 0;
        // answer = new int[answerList.size()];
        // for(Integer value : answerList) {
        //     answer[idx++] = value;
        // }

        // // 데이터 추출
        // for(Map.Entry<String, Genre> entry : album.entrySet()) {
        //     // 2개 뽑기
        //     Genre temp = entry.getValue();
        //     PriorityQueue<int[]> pq = temp.musicList;
        //     for(int i=0; i<2; i++) {
        //         int[] music = pq.poll();
        //         list.add(music[1]);
        //         System.out.println(music[1]);
        //     }
        // }

        return answer;
    }
}