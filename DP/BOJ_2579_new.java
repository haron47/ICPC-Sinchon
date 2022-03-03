import java.util.*;

public class BOJ_2579 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] step = new int[num + 1];
        int[][] dp = new int[num + 1][2];

        for(int i = 1; i <= num; i++)
            step[i] = sc.nextInt();

        if(num == 1){
            System.out.println(step[1]);
            return;
        }

        dp[1][0] = step[1];
        dp[2][0] = step[2];
        dp[2][1] = step[1] + step[2];

        for(int i = 3; i <= num; i++){
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + step[i];
            dp[i][1] = dp[i - 1][0] + step[i];
        }
        int result = Math.max(dp[num][0], dp[num][1]);
        System.out.println(result);
    }
}
