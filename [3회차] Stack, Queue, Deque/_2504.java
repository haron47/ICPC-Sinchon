import java.util.Scanner;
import java.util.Stack;

public class _2504 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		String str = sc.next();

		boolean flag = false;
		int temp = 1;
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push('(');
				temp *= 2;
				flag = true;
			}
			else if (str.charAt(i) == '[') {
				stack.push('[');
				temp *= 3;
				flag = true;
			}
			else if (str.charAt(i) == ')') {
				if(stack.empty() ||stack.pop() != '(') {
					System.out.println(0);
					return;
				}
				if(flag) {
					sum += temp;
					flag = false;
				}
				temp /= 2;
			} else if (str.charAt(i) == ']') {
				if(stack.empty() || stack.pop() != '[') {
					System.out.println(0);
					return;
				}
				if(flag) {
					sum += temp;
					flag = false;
				}
				temp /= 3;
			}
		}
		if(!stack.isEmpty())
			System.out.println(0);
		else
			System.out.println(sum);
	}

}
