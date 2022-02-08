import java.util.*;
public class _20500 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		long[][] dp = new long[1516][3];
		int mod = 1000000007;
		N = sc.nextInt();
		dp[1][0] = 0;
		dp[1][1] = 0;
		dp[1][2] = 1;
		for(int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % mod;  
			dp[i][1] = (dp[i - 1][0] + dp[i -1][2]) % mod;
			dp[i][2] = (dp[i -1][0] + dp[i - 1][1]) % mod;
 		}
		System.out.println(dp[N][0]);
	}
}
