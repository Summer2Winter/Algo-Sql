class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        // 같을때까지 반복
        while(true) {
            // 같은 그룹인지 계산
            int temp1 = (int)Math.ceil(a / 2.0);
            int temp2 = (int)Math.ceil(b / 2.0);

            if(temp1 == temp2){
                break;
            }
            a = temp1;
            b = temp2;
            answer++;
        }

        return answer;
    }
}