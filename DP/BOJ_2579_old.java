import java.util.Scanner;
public class _2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] step = new int[N + 1];
		int[][] dp = new int[N + 1][3];
		for(int i = 1; i <= N; i++)
			step[i] = sc.nextInt();
		dp[1][1] = step[1];
		for(int i = 2; i <= N; i++) {
			dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + step[i];
			dp[i][2] = dp[i - 1][1] + step[i];
		}
		System.out.println(Math.max(dp[N][1], dp[N][2]));
	}
	
}
