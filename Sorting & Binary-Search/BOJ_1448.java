import java.util.*;
import java.io.*;

public class _1448 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;
		int[] straw;
		
		N = Integer.parseInt(br.readLine());
		straw = new int[N];
		
		for(int i = 0; i < N; i++)
			straw[i] = Integer.parseInt(br.readLine());
		Arrays.sort(straw);
		
		for(int i = N - 1; i >= 2; i--) {
			if(straw[i - 2] + straw[i - 1] > straw[i]) {
				System.out.println(straw[i - 2] + straw[i - 1] + straw[i]);
				System.exit(0);
			}
		}
		System.out.println("-1");
	}
}
