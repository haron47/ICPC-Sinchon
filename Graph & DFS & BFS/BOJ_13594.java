import java.util.*;

public class BOJ_13594 {
    static int N;
    static int[] arr;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        ans = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++){
            dfs(i, 1, arr[i]);
        }
        System.out.println(ans);
    }

    public static void dfs(int start, int depth, int result){
        if(depth == 3){
            if(result >= 2000 && result <= 3000)
                ans++;
            return;
        }

        for(int i = start + 1; i < N; i++){
            dfs(i, depth + 1, result + arr[i]);
        }
    }
}
