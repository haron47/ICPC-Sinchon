import java.util.*;

public class _1935 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Double> stack = new Stack<Double>();
		int N = sc.nextInt();
		double[] arr = new double[N];
		String input = sc.next();
		double res = 0;
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != '+' && input.charAt(i) != '-' && input.charAt(i) != '/' && input.charAt(i) != '*') {
				int idx = input.charAt(i) - 65;
				stack.push(arr[idx]);
			}
			else {
				double a1 = stack.pop();
				double a2 = stack.pop();
				if (input.charAt(i) == '+')
					res = a2 + a1;
				else if (input.charAt(i) == '-')
					res = a2 - a1;
				else if (input.charAt(i) == '/')
					res = a2 / a1;
				else if (input.charAt(i) == '*')
					res = a2 * a1;
				stack.push(res);
			}
		}
		System.out.printf("%.2f", stack.pop());
	}
}
