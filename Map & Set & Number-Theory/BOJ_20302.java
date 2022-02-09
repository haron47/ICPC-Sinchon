import java.util.*;
public class _20302 {
	static int[] res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int INF = (int)1E5;
		res = new int[INF + 1];
		int N = sc.nextInt();
		char oper = ' ';
		int num = 0;
		for(int i = 0; i < N; i++) {
			if(i == 0) {
				num = sc.nextInt();
				num = Math.abs(num);
				if(num == 0) {
					System.out.println("mint chocolate");
					return;
				}
				divide_p(num);
			}
			else {
				oper = sc.next().charAt(0);
				num = sc.nextInt();
				if(num == 0) {
					System.out.println("mint chocolate");
					return;
				}
				num = Math.abs(num);
				if(oper == '*') 
					divide_p(num);
				else 
					divide_m(num);
			}
		}
		boolean R_flag = false;
		for(int i = 2; i <= 99991; i++) {
			if(res[i] < 0) {
				R_flag = true;
				break;
			}
		}
		if(R_flag)
			System.out.println("toothpaste");
		else
			System.out.println("mint chocolate");
	}
	public static void divide_p(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i != 0)
				continue;
			while(num % i == 0) {
				res[i]++;
				num /= i;
				if(num < 1)
					return;
			}
		}
		if(num != 1)
			res[num]++;
	}
	public static void divide_m(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i != 0)
				continue;
			while(num % i == 0) {
				res[i]--;
				num /= i;
				if(num < 1)
					return;
			}
		}
		if(num != 1)
			res[num]--;
	}
}