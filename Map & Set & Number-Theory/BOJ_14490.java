import java.util.*;
public class _14490 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String[] s = str.split(":");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int max = Math.max(n, m);
		int min = Math.min(n, m);
		int gcd = gcd(max, min);
		System.out.println((n / gcd) + ":" + (m / gcd));
	}
	public static int gcd(int a, int b) {
		int c = 0;
		while(b > 0) {
			c = a % b;
			a = b;
			b = c;
		}
		return a;
	}
}
