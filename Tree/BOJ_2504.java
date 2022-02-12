//2504 - °ýÈ£ÀÇ °ª
import java.util.*;

public class _2504 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<Character>();
		String input = sc.next();
		int res = 0, temp = 1;
		boolean flag = true;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(') {
				temp *= 2;
				stack.push(input.charAt(i));
			}
			else if(input.charAt(i) == '[') {
				temp *= 3;
				stack.push(input.charAt(i));
			}
			else {
				if(stack.isEmpty()) {
					flag = false;
					break;
				}
				else {
					char ch = stack.pop();
					if(ch == '(' && input.charAt(i) == ')') {
						if(input.charAt(i - 1) == '(')
							res += temp;
						temp /= 2;
					}
					else if(ch == '[' && input.charAt(i) == ']') {
						if(input.charAt(i - 1) == '[')
							res += temp;
						temp /= 3;
					}
					else {
						flag = false;
						break;
					}
				}
			}
		}
		if(!stack.isEmpty() || flag == false)
			System.out.println(0);
		else
			System.out.println(res);
	}
}