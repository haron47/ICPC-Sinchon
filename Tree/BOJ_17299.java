//17299 - 오등큰수
import java.io.*;
import java.util.*;

public class _17299 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new 	OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(bf.readLine());
		int[] A = new int[N + 1];
		int[] F = new int[1000001];
		int[] ans = new int[N + 1];
		String[] input = bf.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			A[i + 1] = Integer.parseInt(input[i]);
			F[A[i + 1]]++;
		}
		int MAX = (int)1e10;
		F[0] = MAX;
		stack.push(0);
		for(int i = N; i >= 1; i--) {
			while(F[stack.peek()] <= F[A[i]])
				stack.pop();
			if(F[stack.peek()] == MAX)
				ans[i] = -1;
			else
				ans[i] = stack.peek();
			stack.push(A[i]);
		}
		
		for(int i = 1; i <= N; i++)
			bw.write(ans[i] + " ");
		bw.flush();
		return;
	}
}
