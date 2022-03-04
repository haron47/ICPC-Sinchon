public interface 큰수만들기 {
    public static void main(String[] args) {
        Solution_큰수만들기 s = new Solution_큰수만들기();
        String number = "1924";
        System.out.println(s.solution(number, 2));
    }
}

class Solution_큰수만들기 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        for(int i=0; i<number.length() - k; i++) {
            max = 0;
            for(int j = index; j<= k+i; j++) {
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}