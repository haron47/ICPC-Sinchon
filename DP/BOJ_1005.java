import java.util.*;

public class _1005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer>[] adjList;
		int T = sc.nextInt();
		while(T > 0) {
			int N = sc.nextInt();
			adjList = new LinkedList[N + 1];
			int[] time = new int[N + 1];
			int[] indegree = new int[N + 1];
			int K = sc.nextInt();
			for(int i = 1; i <= N; i++) {
				adjList[i] = new LinkedList<Integer>();
				time[i] = sc.nextInt();
			}
			for(int i = 1; i <= K; i++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				adjList[X].add(Y);
				indegree[Y]++;
			}
			int[] res = new int[N + 1];
			Queue<Integer> queue = new LinkedList<>();
			int target = sc.nextInt();
			for(int i = 1; i <= N; i++) {
				if(indegree[i] == 0) {
					queue.offer(i);
					res[i] = time[i];
				}
			}
			while(!queue.isEmpty()) {
				int temp = queue.poll();
				for(int v : adjList[temp]) {
					res[v] = Math.max(res[v], res[temp] + time[v]);
					if((--indegree[v]) == 0)
						queue.add(v);
				}
			}
			System.out.println(res[target]);
			T--;
		}

	}

}
