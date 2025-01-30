import java.util.Arrays;

class Music implements Comparable<Music> {
    int start;
    int end;
    int time;
    String name;
    String sound;

    // 변환
    Music(String str) {
        String[] arr = str.split(",");
        this.start = calculateTime(arr[0]);
        this.end = calculateTime(arr[1]);
        this.time = this.end - this.start;
        this.name = arr[2];
        this.sound = generateFullMusic(arr[3], this.time);
    }

    @Override
    public int compareTo(Music m) {
        return m.time - this.time;
    }

    public int calculateTime(String str) {
        String[] arr = str.split(":");
        return (Integer.parseInt(arr[0]) * 60) + Integer.parseInt(arr[1]);
    }

    public String generateFullMusic(String sound, int length) {
        StringBuilder sb = new StringBuilder();

        // # 변환
        sound = sound.replace("C#", "H")
                .replace("D#", "I")
                .replace("F#", "J")
                .replace("G#", "K")
                .replace("A#", "L")
                .replace("B#", "M");

        int soundLength = sound.length();
        int repeatCount = length / soundLength;
        int remain = length % soundLength;

        sb.append(sound.repeat(repeatCount));
        sb.append(sound.substring(0, remain));

        return sb.toString();
    }
}

class Solution {
    public String solution(String m, String[] musicinfos) {
        // # 변환
        m = m.replace("C#", "H")
                .replace("D#", "I")
                .replace("F#", "J")
                .replace("G#", "K")
                .replace("A#", "L")
                .replace("B#", "M");

        // 클래스로 변환
        Music[] musicinfoArr = new Music[musicinfos.length];
        for (int i = 0; i < musicinfos.length; i++) {
            musicinfoArr[i] = new Music(musicinfos[i]);
        }

        // 시간 기준으로 정렬
        Arrays.sort(musicinfoArr);

        // 해당하는 곡 찾기
        for (Music music : musicinfoArr) {
            if (music.sound.contains(m)) {
                return music.name;
            }
        }
        return "(None)";
    }
}
