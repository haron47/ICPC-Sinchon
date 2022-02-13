import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _22865 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] fr = new int[3];
		long[] res = new long[N + 1];
		for(int i = 0; i < 3; i++)
			fr[i] = sc.nextInt();
		
		int M = sc.nextInt();

		ArrayList<Element>[] adjList = new ArrayList[M+1];
		for(int i = 1; i < M + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			adjList[u].add(new Element(v, w));
			adjList[v].add(new Element(u, w));
		}
		for(int i = 1; i <= N; i++)
			res[i] = Long.MAX_VALUE;
		
		for(int j = 0; j < 3; j++) {
		int start = fr[j];
		boolean[] check = new boolean[N + 1];

		long[] distance = new long[N + 1];
		long INF = Long.MAX_VALUE;
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		PriorityQueue<Element> pq = new PriorityQueue<>();
		pq.offer(new Element(start, 0));
		
		while(!pq.isEmpty()) {
			int current = pq.poll().index;
			
			if(check[current]) continue;
			check[current] = true;
			
			for(Element next : adjList[current]) {
				if(distance[next.index] > distance[current] + next.distance) {
					distance[next.index] = distance[current] + next.distance;
					pq.offer(new Element(next.index, distance[next.index]));
				}
			}
		}
		for(int i = 1; i <= N; i++)
			res[i] = Math.min(res[i], distance[i]);
		}

		int ans = 1;
		long max = res[1];
		for(int i = 2; i <= N; i++) {
			if(res[i] > max) {
				max = res[i];
				ans = i;
			}
		}
		System.out.println(ans);
	}
	
}

class Element implements Comparable<Element> {
	int index;
	long distance;

	Element(int index, long distance) {
		this.index = index;
		this.distance = distance;
	}

	@Override
	public int compareTo(Element o) {
		return Long.compare(this.distance, o.distance);
	}
}
