import java.util.*;

public class _1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		bfs(N, K);	
	}
	public static void bfs(int start, int end) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(start, 0));
		int[] check = new int[100001];
		while(!queue.isEmpty()) {
			Pair temp = queue.poll();
			check[temp.num] = 1;
			if(temp.num == end) {
				System.out.println(temp.level);
				return;
			}
			if(temp.num > 0 && check[temp.num - 1] == 0) {
				queue.offer(new Pair(temp.num - 1, temp.level + 1));
			}
			if(temp.num + 1 <= end && temp.num + 1 <= 100000) {
				if(check[temp.num + 1] == 0)
					queue.offer(new Pair(temp.num + 1, temp.level + 1));
			}
			if(temp.num * 2 <= 100000) {
				if(check[temp.num * 2] == 0)
					queue.offer(new Pair(temp.num * 2, temp.level + 1));
			}
		}
		System.out.println(-1);
	}
	static class Pair{
		int num;
		int level;
		public Pair(int num, int level) {
			this.num = num;
			this.level = level;
		}
	}
}
