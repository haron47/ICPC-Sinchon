import java.util.*;
import java.io.*;
public class _11657 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		LinkedList<Pair>[] list = new LinkedList[N + 1];
		long[] dist = new long[N + 1];
		long INF = Long.MAX_VALUE;
		for(int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
			dist[i] = INF; 
		}
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			list[A].add(new Pair(B, C));
		}
		
		boolean negative_cycle = false;
		dist[1] = 0;
		
		for(int i = 1; i <= N; i++) {
			boolean update = false;
			for(int from = 1; from <= N; from++) {
				if(dist[from] == INF)
					continue;
				for(Pair p : list[from]) {
					if(dist[p.end] > dist[from] + p.cost) {
						if(i == N) {
							negative_cycle = true;
							break;
						}
						dist[p.end] = dist[from] + p.cost;
						update = true;
					}
				}
			}
			if(!update)
				break;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		if(negative_cycle)
			sb.append("-1\n");
		else {
			for(int i = 2; i <= N; i++) {
				if(dist[i] == INF) {
					sb.append("-1\n");
				}
				else
					sb.append(dist[i] + "\n");
			}
		}
		 bw.write(sb.toString());
	     bw.flush();
	     bw.close();
	     br.close();
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
