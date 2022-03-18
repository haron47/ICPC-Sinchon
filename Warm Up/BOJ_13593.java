import java.util.*;

public class BOJ_13593 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int res = sc.nextInt();
            int ans = 0;
            while(true){
                if((res - b) % a == 0){
                    ans = (res - b) / a;
                    break;
                }
                res += 26;
            }
            ans += 'a';
            System.out.println((char) ans);
        }
    }
}
