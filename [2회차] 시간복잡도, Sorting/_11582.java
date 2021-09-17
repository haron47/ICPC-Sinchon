import java.util.*;

public class _11582 {
	public static int[] arr;
	public static int[] tmp;
	public static int k;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		k = sc.nextInt();
		mergeSort(0, arr.length -1, 0);
		
		for(int i = 0; i < N; i++)
			System.out.print(arr[i] + " ");
		sc.close();
	}

	public static void mergeSort(int start, int end, int sum) {
		System.out.println(sum);
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		if(sum > k)
			return;
		if (start < end) {
			sum += 1;
			int mid = (start + end) / 2;
			mergeSort(start, mid, sum);
			mergeSort(mid + 1, end, sum);

			int p = start;
			int q = mid + 1;
			int idx = p;

			while (p <= mid || q <= end) {
				if (q > end || (p <= mid && arr[p] < arr[q])) {
					tmp[idx++] = arr[p++];
				} else {
					tmp[idx++] = arr[q++];
				}
			}
			for (int i = start; i <= end; i++) {
				arr[i] = tmp[i];
			}
		}
	}
}
