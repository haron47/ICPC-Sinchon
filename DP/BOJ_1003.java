import java.io.*;
public class _1003 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] res = new int[41][2];
		res[0][0] = 1;
		res[1][1] = 1;
		while(T > 0) {
			int N = Integer.parseInt(br.readLine());
			if(res[N][0] == 0 && res[N][1] == 0) {
				for(int i = 2; i <= N; i++) {
					res[i][0] = res[i - 2][0] + res[i - 1][0];
					res[i][1] = res[i - 2][1] + res[i - 1][1];
				}
			}
			System.out.println(res[N][0] + " " + res[N][1]);
			T--;
		}
	}
}
