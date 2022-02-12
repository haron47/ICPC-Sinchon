import java.util.*;
public class _1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T > 0) {
			int cnt = 0;
			Queue<Integer> queue = new LinkedList<>();
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] doc = new int[N];
			int[] pre = new int[N];
			for(int i = 0; i < N; i++) {
				doc[i] = sc.nextInt();
				pre[i] = doc[i];
				queue.offer(i);
			}
			Arrays.sort(pre);
			while(true) {
				int temp = queue.poll();
				if(pre[N - 1 - cnt] == doc[temp])
					if(temp == M) {
						cnt++;
						System.out.println(cnt);
						break;
					}
					else cnt++;
				else
					queue.offer(temp);
			}
			T--;
		}
	}
}
