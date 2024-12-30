class Solution {
    public int solution(String s) {
        int answer = 0;

        // 숫자 반영
        int[] number = new int[]{4,3,3,5,4,4,3,5,5,4};
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            int size = 0;
            switch(curr) {
                case 'z': {
                    sb.append("0");
                    size = 3;
                    break;
                }
                case 'o': {
                    sb.append("1");
                    size = 2;
                    break;
                }
                case 't': {
                    if(s.charAt(i+1) == 'w') {
                        sb.append("2");
                        size = 2;
                    }
                    else{
                        sb.append("3");
                        size = 4;
                    }
                    break;
                }
                case 'f': {
                    if(s.charAt(i+1) == 'o') {
                        sb.append("4");
                        size = 3;
                    }
                    else{
                        sb.append("5");
                        size = 3;
                    }
                    break;
                }
                case 's': {
                    if(s.charAt(i+1) == 'i') {
                        sb.append("6");
                        size = 2;
                    }
                    else{
                        sb.append("7");
                        size = 4;
                    }
                    break;
                }
                case 'e': {
                    sb.append("8");
                    size = 4;
                    break;
                }
                case 'n': {
                    sb.append("9");
                    size = 3;
                    break;
                }
                default : {
                    sb.append(curr);
                    break;
                }
            }
            i += size;
        }
        answer = Integer.parseInt(sb.toString());
        return answer;
    }
}

// 코드 길이 줄이기
class Solution {
    public int solution(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < strArr.length; i++) {
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}