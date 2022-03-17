import java.util.*;

public class BOJ_24552 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        String S = sc.next();

        int sum = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                sum++;
                left++;
            } else {
                sum--;
                right++;
            }
            if (sum < 0) {
                System.out.println(right);
                return;
            } else if (sum == 0) {
                left = 0;
            }
        }
        System.out.println(left);
    }
}
