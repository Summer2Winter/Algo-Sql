import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static LinkedList<Character> list = new LinkedList<>();
    static LinkedList<Character> answer = new LinkedList<>();
    static boolean possible;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        for(int i=0; i<S.length(); i++) {
            answer.add(S.charAt(i));
        }
        for(int i=0; i<T.length(); i++) {
            list.add(T.charAt(i));
        }

        // 바꾸기
        findAnswer();
        if(!possible)
            System.out.println(0);
    }

    public static void findAnswer(){
        // for(int i=0; i<list.size(); i++){
        //     System.out.print(list.get(i));
        // }
        // System.out.println();
        // 정답 조건
        if(list.size() < answer.size()){
            System.out.println(0);
            System.exit(0);
        }
        else if(list.size() == answer.size()) {
            // 정답인지 확인
            for(int i=0; i<list.size(); i++) {
                if(list.get(i) != answer.get(i)) {
                    System.out.println(0);
                    System.exit(0);
                }
            }
            System.out.println(1);
            System.exit(0);
        }

        // 마지막이 A인 경우
        if(list.get(list.size()-1) == 'A') {
            // A 제거
            list.remove(list.size()-1);
            findAnswer();
        }
        else {
            // B 제거 후 swap
            list.remove(list.size()-1);
            swap();
            findAnswer();
        }
    }

    public static void swap() {
        int cnt = list.size() / 2;
        for(int i=0; i<cnt; i++) {
            char temp1 = list.get(i);
            char temp2 = list.get(list.size()-1-i);
            list.set(i,temp2);
            list.set(list.size()-1-i, temp1);
        }
    }
}

// StringBuilder에 reverse 메소드를 이용하는 방법도 있다.
/*
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)  throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        while (S.length() != T.length()){
            if (T.charAt(T.length()-1) == 'A'){
                T = T.substring(0, T.length() - 1);
            }
            else{
                T = new StringBuilder(T.substring(0, T.length()-1)).reverse().toString();
            }
        }

        if (T.equals(S)) System.out.println(1);
        else System.out.println(0);
    }
}
 */