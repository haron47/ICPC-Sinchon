import java.util.*;
public class _5829 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int[][] port = new int[N + 1][2];
		int[] desti = new int[N + 1];
		int[] circle = new int[N + 1];
		boolean[] visit = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			port[i][0] = sc.nextInt();
			port[i][1] = sc.nextInt();
		}
		int[] direct = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			char input = sc.next().charAt(0);
			if (input == 'R')
				direct[i] = 1;
			else
				direct[i] = 0;

		}
		for (int i = 1; i <= N; i++) {
			int now = i;
			int level = 1;
			while(level <= M) {
				int next = port[now][direct[level]];
				now = next;
				level++;
			}
			desti[i] = now;
		}
		int now = 1;
		int period = 0;
		int start = 0;
		for(int i = 0; i <= N; i++) {
			if(visit[now]) {
				period = i;
				start = now;
				break;
			}
			circle[i] = now;
			visit[now] = true;
			now = desti[now];
		}
		for(int i = 0; i <= N; i++) {
			if(circle[i] == start) {
				period -= i;
				start = i;
				break;
			}
			if(K == 0) {
				System.out.println(circle[i]);
				return;
			}
			K--;
		}
		K %= period;
		System.out.println(circle[start + K]);
	}
}