import java.util.*;

public class _11403 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dist = new int[N][N];
		int INF = 987654321;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				if (temp == 0)
					dist[i][j] = INF;
				else
					dist[i][j] = temp;
			}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				for (int k = 0; k < N; k++)
					dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dist[i][j] == INF)
					System.out.print(0 + " ");
				else
					System.out.print(1 + " ");
			}
			System.out.println();
		}
	}
}
