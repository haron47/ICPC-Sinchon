import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class _1302 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<String, Integer>();
		// List<Integer> keySetList = new ArrayList(map.keySet());
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			if (map.containsKey(str))
				map.put(str, map.get(str) + 1);
			else
				map.put(str, 1);
		}
		int max = 0;
		for (String a : map.keySet())
			max = Math.max(max, map.get(a));
		ArrayList<String> al = new ArrayList<String>(map.keySet());
		Collections.sort(al);
		for (String a : al) {
			if (map.get(a) == max) {
				System.out.println(a);
				break;
			}
		}
	}
}
