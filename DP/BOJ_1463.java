import java.util.*;

public class BOJ_1463 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        int[] dp = new int[input + 1];
        dp[1] = 0;

        for(int i = 2; i <= input; i++){
            if((i % 2 == 0) && i % 3 == 0)
                dp[i] = Math.min(dp[i / 2], dp[i / 3]) + 1;
            else if(i % 2 == 0)
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
            else if(i % 3 == 0)
                dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
            else
                dp[i] = dp[i - 1] + 1;
        }
        System.out.println(dp[input]);
    }
}
