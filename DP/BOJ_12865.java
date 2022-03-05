import java.util.*;

public class BOJ_12865 {
    static int N, K, max;
    static int[][] baenang;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        baenang = new int[N + 1][2];
        for(int i = 1; i <= N; i++){
            baenang[i][0] = sc.nextInt();
            baenang[i][1] = sc.nextInt();
        }
        max = 0;

        int[][] dp = new int[N + 1][K + 1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){
                if(baenang[i][0] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - baenang[i][0]] + baenang[i][1]);
            }
        }
        System.out.println(dp[N][K]);
    }
}
