import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int w, s;
    static String W, S;
    static int[] firstWords, secondWords;

    static StringTokenizer st;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        firstWords = new int[52]; // 알파멧 대,소문자 개수 : 52
        secondWords = new int[52];

        st = new StringTokenizer(br.readLine());
        W = st.nextToken();
        st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        for (char c : W.toCharArray()) { // 첫번째 단어 W의 알파벳 세기

            countWordCnt(c, firstWords, 1);
        }

        int start = 0, cnt = 0, size = 0;
        for (int i = 0; i < s; i++) {

            char c = S.charAt(i);
            countWordCnt(c, secondWords, 1); // 두번째 단어 S의 알파벳 세기
            size += 1;

            if (size == w) {

                if (Arrays.equals(firstWords, secondWords)) // 단어 배열 비교 (만약 같다면 W의 순열이 S의 부분집합으로 존재 한다는 의미★)
                    cnt += 1;

                countWordCnt(S.charAt(start), secondWords, -1); // 처음 문자 빼기
                start += 1; // 슬라이딩 윈도우
                size -= 1;
            }
        }

        System.out.println(cnt);
    }

    private static void countWordCnt(char c, int[] words, int cnt) {

        if ('a' <= c && c <= 'z')
            words[c - 'a'] += cnt;
        else
            words[c - 'A' + 26] += cnt;
    }
}