import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11582 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i += N / k)
			Arrays.sort(arr, i, i + N / k);
		for (int i = 0; i < N; i++)
			System.out.print(arr[i] + " ");
	}
}
