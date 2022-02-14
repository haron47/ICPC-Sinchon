import java.util.*;
public class _21555 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, K;
		
		N = sc.nextInt();
		K = sc.nextInt();
		long[] A = new long[N];
		long[] B = new long[N];
		long[][] dp = new long[N][2];
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		for(int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}

		dp[0][0] = A[0];
		dp[0][1] = B[0];
		
		for(int i = 1; i < N; i++) {
			dp[i][0] = Math.min(A[i] + dp[i -1][0], A[i] + K + dp[i - 1][1]);
			dp[i][1] = Math.min(B[i] + K + dp[i -1][0], B[i] + dp[i - 1][1]);
		}
		System.out.println(Math.min(dp[N - 1][0], dp[N - 1][1]));
	}

}
