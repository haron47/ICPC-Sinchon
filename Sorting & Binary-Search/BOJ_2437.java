import java.util.*;
public class _2437 {
	public static int N;
	public static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			if(sum + 2 <= arr[i])
				break;
			sum += arr[i];
		}
		System.out.println(sum + 1);
		sc.close();
	}

}
