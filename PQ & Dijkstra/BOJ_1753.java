//1753 - 최단경로
import java.util.*;
public class _1753 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		int V = sc.nextInt();
		LinkedList<Pair>[] node = new LinkedList[V + 1];
		int[] dist = new int[V + 1];
		int INF = Integer.MAX_VALUE;
		int E = sc.nextInt();
		int K = sc.nextInt();
		for(int i = 1; i <= V; i++) {
			node[i] = new LinkedList<Pair>(); 
			dist[i] = INF;
		}
		for(int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			node[u].add(new Pair(v, w));
		}
		dist[K] = 0;
		pq.offer(new Pair(K, 0));
		while(!pq.isEmpty()) {
			Pair temp = pq.poll();
			if(dist[temp.num] < temp.weight)
				continue;
			for(Pair p : node[temp.num]) {
				if(dist[p.num] <= temp.weight + p.weight)
					continue;
				dist[p.num] = temp.weight + p.weight;
				pq.offer(new Pair(p.num, dist[p.num]));
			}
		}
		for(int i = 1; i <= V; i++) {
			if(dist[i] == INF)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}
	static class Pair implements Comparable<Pair> {
	    int num;
	    int weight;

	    public Pair(int num, int weight) {
	        this.num = num;
	        this.weight = weight;
	    }

	    @Override
	    public int compareTo(Pair o) {
	        // TODO Auto-generated method stub
	        return Integer.compare(this.weight, o.weight);
	    }
	}
}
