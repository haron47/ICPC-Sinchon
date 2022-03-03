import java.util.*;
public class BOJ_9095 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] n = new int[T];
        int max = 0;
        for(int i = 0; i < T; i++){
            n[i] = sc.nextInt();
            max = Math.max(max, n[i]);
        }

        int[] dp = new int[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i <= max; i++)
            dp[i] = dp[i -3] + dp[i - 2] + dp[i - 1];

        for(int i = 0; i < T; i++)
            System.out.println(dp[n[i]]);
    }
}
