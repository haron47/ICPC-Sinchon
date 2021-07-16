import java.util.*;

public class _1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] res = new int[N];
		for (int i = 1; i <= N; i++)
			queue.offer(i);
		int cnt = 0;
		int idx = 0;
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			cnt++;
			if (cnt == K) {
				res[idx] = temp;
				idx++;
				cnt = 0;
			} else
				queue.offer(temp);
		}
		System.out.print("<");
		for(int i = 0; i < N - 1; i++) {
			System.out.print(res[i] + ", ");
		}
		System.out.print(res[N - 1] + ">");
	}

}
