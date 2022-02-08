import java.io.*;
import java.util.StringTokenizer;
public class _1978 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] era = new int[1001];
		era[0] = era[1] = -1;
		for(int i = 2; i <= 1000; i++)
			era[i] = i;
		for(int i = 2; i <= Math.sqrt(1000); i++) {
			if(era[i] == i) {
				for(int j = i * i; j <= 1000; j += i)
					if(era[j] == j)
						era[j] = i;
			}
		}
		int cnt = 0;
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num  = Integer.parseInt(st.nextToken());
			if(era[num] == num)
				cnt++;
		}
		System.out.println(cnt);
	}
}
