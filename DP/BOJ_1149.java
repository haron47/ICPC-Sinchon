import java.util.*;

public class BOJ_1149 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] house = new int[N + 1][3];

        for(int i = 1; i <= N; i++){
            house[i][0] = sc.nextInt();
            house[i][1] = sc.nextInt();
            house[i][2] = sc.nextInt();
        }
        int[][] dp = new int[N + 1][3];

        dp[1][0] = house[1][0];
        dp[1][1] = house[1][1];
        dp[1][2] = house[1][2];

        for(int i = 2; i <= N; i++){
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + house[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + house[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + house[i][2];
        }

        int min = Math.min(dp[N][0], dp[N][1]);
        min = Math.min(min, dp[N][2]);

        System.out.println(min);
    }
}
