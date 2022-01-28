import java.util.*;
import java.io.*;
public class _2002 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new HashMap<String, Integer>();
		int N = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			map.put(str, i);
		}
		ArrayList<String> keySetList = new ArrayList<String>(map.keySet());
		Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));
		int cnt = 0, idx = 0;
		for(String  s : keySetList) {
			if(visited[map.get(s)])
				continue;
			while(idx < N) {
				String input = br.readLine();
				idx++;
				if(s.equals(input))
					break;
				else {
					cnt++;
					visited[map.get(input)] = true;
				}
			}
		}
		System.out.println(cnt);
	}
}
