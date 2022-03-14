import java.util.*;

public class BOJ_10844 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] dp = new int[N + 1][11];

        for(int i = 0; i < 10; i++)
            dp[1][i] = 1;

        for(int i = 2; i <= N; i++){
            dp[i][0] = dp[i - 1][1];
            for(int j = 1; j < 10; j++){
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }
        int sum = 0;
        for(int i = 1; i < 10; i++)
            sum = (sum + dp[N][i]) % 1000000000;
        System.out.println(sum);
    }
}
