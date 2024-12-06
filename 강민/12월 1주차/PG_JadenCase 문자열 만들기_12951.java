import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        StringTokenizer st = new StringTokenizer(s, " ", true);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals(" ")) {
                sb.append(" ");
            }
            else {
                char firstChar = token.charAt(0);
                sb.append(Character.toUpperCase(firstChar)).append(token.substring(1));
            }
        }
        return sb.toString();
    }
}