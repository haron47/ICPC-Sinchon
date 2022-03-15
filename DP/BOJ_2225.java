import java.util.*;

public class BOJ_2225 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dp = new int[K + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= K; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= N; j++) {
                for(int k = 0; k <= j; k++){
                    dp[i][j] += dp[i - 1][j - k];
                    dp[i][j] %= 1000000000;
                }
            }
        }
        System.out.println(dp[K][N]);
    }
}
