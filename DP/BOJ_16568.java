import java.util.Scanner;
public class _16568 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dp = new int[1000002];
		int n, a, b;
		n = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			dp[i] = 1000001;
		}
		if(b > a) {
			int temp = a;
			a = b;
			b = temp;
		}
		for(int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			if(i - a - 1 >= 0) {
				dp[i] = Math.min(dp[i],dp[i - a - 1] + 1);
			}
			if(i - b - 1 >= 0) {
				dp[i] = Math.min(dp[i],dp[i - b - 1] + 1);
			}
		}
		System.out.print(dp[n]);
	}
}