import java.io.*;
import java.util.*;
public class _16563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 2; i <= 5000000; i++)
			map.put(i, i);
		for(int i = 2; i < Math.sqrt(5000001); i++) {
			if(map.get(i) == i) {
				for(int j = i * i; j <= 5000000; j += i)
					if(map.get(j) == j)
						map.put(j,i);
			}
		}
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num  = Integer.parseInt(st.nextToken());
			while(num > 1) {
				sb.append(map.get(num) +" ");
				num /= map.get(num);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}