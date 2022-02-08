import java.util.*;

public class _20046 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] map = new int[m + 1][n + 1];
		int[][] dist = new int[m + 1][n + 1];
		int INF = Integer.MAX_VALUE;
		for(int i = 1; i <= m; i++)
			for(int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
				dist[i][j] = INF;
			}
		if(map[1][1] == -1 || map[m][n] == -1) {
			System.out.println(-1);
			return;
		}
		dist[1][1] = map[1][1];
		pq.offer(new Pair(1, 1, dist[1][1]));
		while(!pq.isEmpty()) {
			Pair temp = pq.poll();
			if(dist[temp.x][temp.y] < temp.weight) 
				continue;
			
			if(temp.x + 1 <= m && map[temp.x + 1][temp.y] != -1) {
				if(dist[temp.x + 1][temp.y] > temp.weight + map[temp.x + 1][temp.y]) {
					dist[temp.x + 1][temp.y] = temp.weight + map[temp.x + 1][temp.y];
					pq.offer(new Pair(temp.x + 1, temp.y, dist[temp.x + 1][temp.y]));
				}
			}
			if(temp.y + 1 <= n && map[temp.x][temp.y + 1] != -1) {
				if(dist[temp.x][temp.y + 1] > temp.weight + map[temp.x][temp.y + 1]) {
					dist[temp.x][temp.y + 1] = temp.weight + map[temp.x][temp.y + 1];
					pq.offer(new Pair(temp.x, temp.y + 1, dist[temp.x][temp.y + 1]));
				}
			}
			if(temp.x - 1 >= 1 && map[temp.x - 1][temp.y] != -1) {
				if(dist[temp.x - 1][temp.y] > temp.weight + map[temp.x - 1][temp.y]) {
					dist[temp.x - 1][temp.y] = temp.weight + map[temp.x - 1][temp.y];
					pq.offer(new Pair(temp.x - 1, temp.y, dist[temp.x - 1][temp.y]));
				}
			}
			if(temp.y - 1 >= 1 && map[temp.x][temp.y - 1] != -1) {
				if(dist[temp.x][temp.y - 1] > temp.weight + map[temp.x][temp.y - 1]) {
					dist[temp.x][temp.y - 1] = temp.weight + map[temp.x][temp.y - 1];
					pq.offer(new Pair(temp.x, temp.y - 1, dist[temp.x][temp.y - 1]));
				}
			}
		}
		if(dist[m][n] == INF)
			System.out.println(-1);
		else
			System.out.println(dist[m][n]);
	}
	static class Pair implements Comparable<Pair>{
		int x, y;
		int weight;
		
		Pair(int x, int y, int weight){
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}
}
