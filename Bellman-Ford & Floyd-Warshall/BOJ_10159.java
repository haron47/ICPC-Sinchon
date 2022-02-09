//10159 - Àú¿ï
import java.util.*;
public class _10159 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] dist = new int[n + 1][n + 1];
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			dist[a][b] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if(dist[j][i]== 1 && dist[i][k] == 1)
						dist[j][k] = 1;
				}
			}
		}
		for(int i = 1; i <= n; i++) {
			int cnt = -1;
			for(int j = 1; j <= n; j++) {
				if(dist[i][j] == 0 && dist[j][i] == 0)
					cnt++;
			}
			System.out.println(cnt);
		}
	}
}