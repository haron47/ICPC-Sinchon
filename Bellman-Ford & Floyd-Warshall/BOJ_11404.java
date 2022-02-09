import java.util.*;
public class _11404 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int INF = Integer.MAX_VALUE;
		long[][] dist = new long[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j)
					continue;
				dist[i][j] = INF;
			}
		}
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			dist[a][b] = Math.min(dist[a][b], c);
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++)
					dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
			}
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(dist[i][j] == INF)
					System.out.print(0 + " ");
				else
					System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}

}
