import java.util.*;
public class _2812 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		int[] res = new int[N - K];
		String str = sc.next();
		for(int i = 0; i < N; i++)
			arr[i] = (str.charAt(i) - '0');
		int cnt = 0;
		int cnt_in = 1;
		int cnt_out = 0;
		stack.push(arr[0]);
		for(int i = 1; i < N; i++) {
			cnt = cnt_in - cnt_out;
			if(stack.peek() < arr[i]) {
				while(stack.peek() < arr[i] && cnt_out < K) {
					stack.pop();
					cnt_out++;
					if(stack.isEmpty())
						break;
				}
				stack.push(arr[i]);
				cnt_in++;
			}
			else if(stack.peek() >= arr[i] && cnt < N - K) {
				stack.push(arr[i]);
				cnt_in++;
			}
			
		}
		for(int i = N - K - 1; i >= 0; i--)
			res[i] = stack.pop();
		for(int i = 0; i < N - K; i++)
			System.out.print(res[i]);
	}
}
