import java.util.*;

public class BOJ_1309 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] dp = new int[N + 1][3];

        for (int i = 0; i < 3; i++) {
            dp[1][i] = 1;
        }

        int div = 9901;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % div;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % div;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % div;
        }

        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans = (ans + dp[N][i]) % div;
        }

        System.out.println(ans % div);
    }
}
