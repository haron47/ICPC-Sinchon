import java.util.*;

public class _10610 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String N = sc.next();
		char[] arr;
		boolean hasZero = false;
		int sum = 0;
		
		for(int i = 0; i < N.length(); i++) {
			if(N.charAt(i) - '0' == 0)
				hasZero = true;
			sum += N.charAt(i) - '0';	
		}
		
		if(hasZero && sum % 3 == 0) {
			arr = N.toCharArray();
			Arrays.sort(arr);
			for(int i = N.length() - 1; i >= 0; i--)
				sb.append(arr[i]);
		}else {
			sb.append(-1);
		}
		System.out.print(sb.toString());
		sc.close();
	}

}
