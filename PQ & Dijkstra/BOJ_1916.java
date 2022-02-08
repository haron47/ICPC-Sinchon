import java.util.*;
public class _1916 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		 int N = sc.nextInt();
		 int M = sc.nextInt();
		 LinkedList<Pair>[] node = new LinkedList[N + 1];
		 int[] dist = new int[N + 1];
		 int INF = Integer.MAX_VALUE;
		 for(int i = 1; i <= N; i++) {
			 node[i] = new LinkedList<Pair>();
			 dist[i] = INF;
		 }
		 for(int i = 1; i <= M; i++) {
			 int s = sc.nextInt();
			 int e = sc.nextInt();
			 int w = sc.nextInt();
			 node[s].add(new Pair(e, w));
		 }
		 int start = sc.nextInt();
		 int desti = sc.nextInt();
		 dist[start] = 0;
		 pq.offer(new Pair(start, 0));
		 while(!pq.isEmpty()) {
				Pair temp = pq.poll();
				System.out.println(temp.end + " ");
				if(dist[temp.end] < temp.weight) {
					System.out.println("P " + temp.end + " " + temp.weight);
					continue;
				}
				for(Pair p : node[temp.end]) {
					if(dist[p.end] <= temp.weight + p.weight)
						continue;
					dist[p.end] = temp.weight + p.weight;
					System.out.println(p.end + " ");
					pq.offer(new Pair(p.end, dist[p.end]));
				}
				System.out.println();
			}
		 System.out.println(dist[desti]);
	}
	static class Pair implements Comparable<Pair>{
		int end;
		int weight;
		
		Pair(int end, int weight){
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}
}
