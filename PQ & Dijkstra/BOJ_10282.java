import java.util.*;

public class _10282 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		int T = sc.nextInt();
		while(T > 0) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			int c = sc.nextInt();
			LinkedList<Pair>[] node = new LinkedList[n + 1];
			int[] dist = new int[n + 1];
			int INF = Integer.MAX_VALUE;
			for(int i = 1; i <= n; i++) {
				node[i] = new LinkedList<Pair>();
				dist[i] = INF;
			}
			for(int i = 1; i <= d; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int s = sc.nextInt();
				node[b].add(new Pair(a, s));
			}
			dist[c] = 0;
			pq.offer(new Pair(c, 0));
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
			int Max = 0;
			int cnt = 0;
			for(int i = 1; i <= n; i++) {
				if(dist[i] == INF)
					continue;
				cnt++;
				Max = Math.max(Max, dist[i]);
			}
			System.out.println(cnt + " " + Max);
			T--;
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
