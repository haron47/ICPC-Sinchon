import java.util.*;
import java.io.*;

public class _1865 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			LinkedList<Pair>[] node = new LinkedList[N + 1];
			int[] dist = new int[N + 1];
			for(int i = 1; i <= N; i++) 
				node[i] = new LinkedList<Pair>();
			
			for(int i = 1; i <= M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				node[s].add(new Pair(e, t));
				node[e].add(new Pair(s, t));
			}
			for(int i = 1; i <= W; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				node[s].add(new Pair(e, (-1) * t));
			}
			boolean negative_cycle = false;
			int INF = Integer.MAX_VALUE;
			for(int i = 1; i <= N; i++)
				dist[i] = INF;
			dist[1] = 0;
			loop:
			for(int i = 1; i <= N; i++) {
				boolean update = false;
				for(int from = 1; from <= N; from++) {
					for(Pair p : node[from]) {
						if(dist[p.end] > dist[from] + p.cost) {
							if(i == N) {
								negative_cycle = true;
								break loop;
							}
							dist[p.end] = dist[from] + p.cost;
							update = true;
						}
					}
				}
				if(!update)
					break;
			}
			sb.append((negative_cycle ? "YES" : "NO") + "\n");
		}
		System.out.println(sb);
	}
	static class Pair{
		int end;
		int cost;
		Pair(int end, int cost){
			this.end = end;
			this.cost = cost;
		}
	}
}
