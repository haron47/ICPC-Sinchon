import java.util.*;
public class _1021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int sum = 0, cnt;
		int[] input = new int[M + 1];
		for(int i = M; i > 0; i--)
			input[i] = sc.nextInt();
		for(int i = 1; i <= N; i++)
			deque.offer(i);
		while(M > 0) {
			cnt = 0;
			int temp = deque.poll();
			while(temp != input[M]) {
				cnt++;
				deque.offerLast(temp);
				temp = deque.poll();
			}
			if(cnt <= N / 2) 
				sum += cnt;
			else 
				sum += (N - cnt);
			N--;
			M--;
		}
		System.out.println(sum);
	}
}
