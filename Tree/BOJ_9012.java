import java.util.*;

public class _9012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String input;
		Stack<Character> stack;
		while (T > 0) {
			input = sc.next();
			stack = new Stack<Character>();
			int flag = 1;
			int size = input.length();
			for (int i = 0; i < size; i++) {
				if (input.charAt(i) == '(')
					stack.push('(');
				else {
					if (stack.isEmpty()) {
						flag = 0;
						break;
					} else
						stack.pop();
				}
			}
			if(flag == 0 || !stack.isEmpty())
				System.out.println("NO");
			else if (stack.empty())
				System.out.println("YES");
			
		}
	}
}
