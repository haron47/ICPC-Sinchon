import java.util.*;
public class _10804 {
	static int[] card;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		card = new int[21];
		int a, b;
		for(int i = 1; i < 21; i++)
			card[i] = i;
		for(int i = 0; i < 10; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			reverseArray(a, b);
		}
		for(int i = 1; i < 21; i++)
			System.out.print(card[i] + " ");
		sc.close();
	}
	static void reverseArray(int s, int e) {
		int size = (e - s + 1) / 2;
		int temp;
		for(int i = 0; i < size; i++) {
			temp = card[s];
			card[s] = card[e];
			card[e] = temp;
			s++;
			e--;
		}
	}
}
