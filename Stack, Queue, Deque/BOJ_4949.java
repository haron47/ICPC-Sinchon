import java.util.*;
public class _4949 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack;
		String input;
		while(true) {
			input = sc.nextLine();
			if(input.equals("."))
				break;
			stack = new Stack<Character>();
			int flag = 0;
			
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == '(' || input.charAt(i) == '[')
					stack.push(input.charAt(i));
				else if(input.charAt(i) == ')') {
					if(!stack.isEmpty()) {
						char temp = stack.peek();
							if(temp == '(')
								stack.pop();
							else {
								flag = 1;
								break;
							}
					}
					else {
						flag = 1;
						break;
					}
				}
				else if(input.charAt(i) == ']') {
					if(!stack.isEmpty()) {
						char temp = stack.peek();
							if(temp == '[')
								stack.pop();
							else {
								flag = 1;
								break;
							}
					}
					else {
						flag = 1;
						break;
					}
				}
			}
			if(!stack.isEmpty() || flag == 1)
				System.out.println("no");
			else
				System.out.println("yes");
		}

	}

}
