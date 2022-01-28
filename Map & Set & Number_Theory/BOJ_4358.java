import java.util.*;
import java.io.*;
public class _4358 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new HashMap<String, Integer>();
		String input = br.readLine();
		float sum = 0;
		while(input != null) {
			if (map.containsKey(input))
				map.put(input, map.get(input) + 1);
			else
				map.put(input, 1);
			sum++;
			input = br.readLine();
		}
		ArrayList<String> al = new ArrayList<String>(map.keySet());
		Collections.sort(al);
		float res = 0;
		for (String a : al) {
			res = map.get(a) / sum * 100;
			System.out.printf("%s %.4f\n", a, res);
		}
	}
}
