import java.util.*;
public class _11780 {
	static Stack<Integer> s;
	static int[][] path;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int INF = 987654321;
		int[][] dist = new int[n + 1][n + 1];
		path = new int[n + 1][n + 1];
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
				for (int k = 1; k <= n; k++) {
					if(dist[j][i] + dist[i][k] < dist[j][k]) {
						dist[j][k] = dist[j][i] + dist[i][k];
						path[j][k] = i;
					}
				}
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
		Stack<Integer> temp = new Stack<Integer>();
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(dist[i][j] == INF || i == j) {
					System.out.println(0);
					continue;
				}
				s = new Stack<Integer>();
				findRoute(i, j);
				System.out.print(s.size() + " ");
				while(!s.isEmpty()) {
					temp.push(s.pop());
				}
				while(!temp.isEmpty()) {
					System.out.print(temp.pop() + " ");
				}
				System.out.println();
			}
		}
	}
	public static void findRoute(int start, int end) {
		if(path[start][end] == 0) {
			s.push(start);
			if(start != end)
				s.push(end);
		}
		else {
			int temp = path[start][end];
			findRoute(start, temp);
			s.pop();
			findRoute(temp, end);
		}
	}

}
