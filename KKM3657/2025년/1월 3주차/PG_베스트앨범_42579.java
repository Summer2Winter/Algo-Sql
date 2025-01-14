import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;

class Genre {
    String genreName;
    int totalPlay;

    Genre(String genreName, int totalPlay) {
        this.genreName = genreName;
        this.totalPlay = totalPlay;
    }
}
class Song {
    int idx;
    int play;

    Song(int idx, int play) {
        this.idx = idx;
        this.play = play;
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genre = new HashMap<>();
        HashMap<String, PriorityQueue<Song>> track = new HashMap<>();

        // 장르별 곡 수 집계
        for(int i=0; i<genres.length; i++) {
            String genreName = genres[i];   // 장르 이름
            int playCnt = plays[i]; // 재생 횟수
            // 장르 전체 집계
            genre.put(genreName, genre.getOrDefault(genreName, 0) + playCnt);

            // 장르 별 곡 정보
            if(track.containsKey(genreName)) {
                PriorityQueue<Song> pq = track.get(genreName);
                pq.add(new Song(i, playCnt));
            }
            else {
                // 우선 순위 큐
                PriorityQueue<Song> pq = new PriorityQueue<>((x,y) -> {
                    return x.play == y.play ? x.idx - y.idx : y.play - x.play;
                });
                pq.add(new Song(i, playCnt));
                track.put(genreName, pq);
            }
        }
        // 장르 순서 정렬
        PriorityQueue<Genre> pq = new PriorityQueue<>((x,y) -> y.totalPlay - x.totalPlay);
        for(String genreName : genre.keySet()) {
            int totalPlay = genre.get(genreName);
            pq.add(new Genre(genreName, totalPlay));
        }

        // 장르별 곡 뽑기
        ArrayList<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()) {
            Genre curr = pq.poll();
            String genreName = curr.genreName;

            PriorityQueue<Song> songList = track.get(genreName);
            // 곡정보 불러오기
            if(songList.size() <= 1) {
                list.add(songList.poll().idx);
            }
            else {
                list.add(songList.poll().idx);
                list.add(songList.poll().idx);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}