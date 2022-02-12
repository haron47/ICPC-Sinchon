import java.util.*;
public class _1725 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		int N = sc.nextInt();
		int[] arr = new int[N + 2];
		int res = 0;
		for(int i = 0; i < N; i++)
			arr[i + 1] = sc.nextInt();
		stack.push(0);
		for(int i = 1; i <= N + 1; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				int height = arr[stack.peek()];
				int width = i - 1 - stack.peek();
				stack.pop();
				System.out.println(height + " " + width);
				res = Math.max(res, height * width);
			}
			stack.push(i);
		}
		//System.out.println(res);
	}

}
