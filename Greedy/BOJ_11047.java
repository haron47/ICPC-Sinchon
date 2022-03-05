import java.util.*;

public class BOJ_11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N + 1];

        for(int i = 1; i <= N; i++)
            A[i] = sc.nextInt();

        int now = K;
        int result = 0;
        for(int i = N; i >= 1; i--){
            if(now / A[i] > 0){
                int quo = now / A[i];
                now = now - quo * A[i];
                result += quo;
            }
        }
        System.out.println(result);
    }
}
