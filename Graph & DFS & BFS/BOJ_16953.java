import java.util.*;
public class _16953 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();
		bfs(A, B);
	}
	public static void bfs(long start, long end) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(start, 0));
		while(!queue.isEmpty()) {
			Pair temp = queue.poll();
			if(temp.num == end) {
				System.out.println(temp.level + 1);
				return;
			}
			if(temp.num * 2 <= end)
				queue.offer(new Pair(temp.num * 2, temp.level + 1));
			if(temp.num * 10 + 1 <= end)
				queue.offer(new Pair(temp.num * 10 + 1, temp.level + 1));
		}
		System.out.println(-1);
	}
	static class Pair{
		long num;
		int level;
		public Pair(long num, int level) {
			this.num = num;
			this.level = level;
		}
	}
}