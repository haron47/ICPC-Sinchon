import java.util.*;
import java.io.*;
public class _31545987 {
	static int N;
	static int[][] S;
	static boolean[] check;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		S= new int[N][N];
		check = new boolean[N];
		
		for(int i = 0; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		bw.write(String.valueOf(min));
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int idx,int cnt) {
		if(cnt == N / 2) {
			cal();
			return;
		}
		
		for(int i = idx; i < N; i++) {
			if(!check[i]) {
				check[i] = true;
				dfs(i+1,cnt+1);
				check[i] = false;
			}
		}
	}
	
	static void cal() {
		int start = 0;
		int link = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if( check[i] == true && check[j] == true) {
					start += S[i][j];
					start += S[j][i];
				}else if( check[i] == false && check[j] == false) {
					link += S[i][j];
					link += S[j][i];
				}
			}
		}
		min = Math.min(Math.abs(start-link), min);
	}
}