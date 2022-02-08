//12865 - 평범한 배낭
import java.util.*;
public class _12865 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, K;
		int[][] dp = new int[101][100001];
		int[] W = new int[101];
		int[] V = new int[101];
		
		N = sc.nextInt();
		K = sc.nextInt();
		for(int i = 1; i <= N; i++) {
			W[i] = sc.nextInt(); //물품의 무게
			V[i] = sc.nextInt(); //물품의 가치
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				if(j < W[i])
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
			}
		}
		System.out.print(dp[N][K]);
		sc.close();
	}
}
