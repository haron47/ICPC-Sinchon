import java.io.*;
import java.util.*;

public class _17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new 	OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(bf.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int[] A = new int[N];
		int[] ans = new int[N];
		String[] input = bf.readLine().split(" ");
		for(int i = 0; i < N; i++)
			A[i] = Integer.parseInt(input[i]);
		int MAX = (int)1e10;
		stack.push(MAX);
		for(int i = N - 1; i >= 0; i--) {
			while(stack.peek() <= A[i])
				stack.pop();
			if(stack.peek() == MAX)
				ans[i] = -1;
			else
				ans[i] = stack.peek();
			stack.push(A[i]);
		}
		
		for(int i = 0; i < N; i++)
			bw.write(ans[i]+" ");
		bw.flush();
		return;
	}
}