import java.util.*;

public class _1918 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<Character>();
		String str = sc.next();
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 65 && str.charAt(i) <= 90)
				System.out.print(str.charAt(i));
			else {
				if(str.charAt(i) == '*' || str.charAt(i) == '/') {
					while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
						System.out.print(stack.pop());
					}
					stack.push(str.charAt(i));
				}
				else if(str.charAt(i) == '+' || str.charAt(i) == '-') {
					while(!stack.isEmpty() && stack.peek() != '(')
						System.out.print(stack.pop());
					stack.push(str.charAt(i));
				}
				else if(str.charAt(i) == ')') {
					while(!stack.isEmpty() && stack.peek() != '(')
						System.out.print(stack.pop());
					stack.pop();
				}
				else {
					stack.push(str.charAt(i));
				}
			}
		}
		while(!stack.isEmpty())
			System.out.print(stack.pop());
	}
}
