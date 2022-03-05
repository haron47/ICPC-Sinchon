import java.util.*;

public class BOJ_12931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] B = new int[N];
        for(int i = 0; i < N; i++)
            B[i] = sc.nextInt();

        int answer = 0;
        while(true){
            boolean flag = true;
            for(int i = 0; i < N; i++){
                if(B[i] % 2 == 1){
                    B[i]--;
                    answer++;
                }
            }
            for(int i = 0; i < N; i++){
                if(B[i] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag)
                break;
            for(int i = 0; i < N; i++)
                B[i] /= 2;
            answer++;
            for(int i = 0; i < N; i++){
                if(B[i] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag)
                break;
        }
        System.out.println(answer);
    }
}
