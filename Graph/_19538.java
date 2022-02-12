import java.io.*;
import java.util.*;

public class _19538 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		LinkedList<Integer> list[] = new LinkedList[N + 1];
		int[] rumor = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			int idx = 0;
			String[] input = bf.readLine().split(" ");
			int temp = Integer.parseInt(input[idx]);
			list[i] = new LinkedList<Integer>();
			while(temp != 0) {
				list[i].addFirst(temp);
				temp = Integer.parseInt(input[++idx]);
			}
			rumor[i] = -1;
		}
		int M = Integer.parseInt(bf.readLine());
		String[] input = bf.readLine().split(" ");
		Queue<Pair> queue = new LinkedList<>();
		for(int i = 0; i < M; i++) {
			int temp = Integer.parseInt(input[i]);
			queue.offer(new Pair(temp, 0));
			rumor[temp] = 0;
		}
		while (!queue.isEmpty()) {
			Pair temp = queue.poll();
			for (Integer j : list[temp.num]) {
				if (rumor[j] == -1) {
					int cnt = 0;
					for (Integer i : list[j]) {
						if (rumor[i] != -1 && rumor[i] < temp.time + 1)
							cnt++;
					}
					if ((list[j].size() + 1) / 2 <= cnt) {
						rumor[j] = temp.time + 1;
						queue.offer(new Pair(j, temp.time + 1));
					}
				}
			}
		}
		BufferedWriter bw = new BufferedWriter(new 	OutputStreamWriter(System.out));
		for(int i = 1; i <= N; i++)
			bw.write(rumor[i]+" ");
		bw.flush();
		return;
	}

	static class Pair{
		int num;
		int time;
		public Pair(int num, int level) {
			this.num = num;
			this.time = level;
		}
	}
}