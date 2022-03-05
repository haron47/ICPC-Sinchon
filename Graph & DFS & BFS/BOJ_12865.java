import java.util.*;

public class BOJ_12865 {
    static int N, K, max;
    static int[][] baenang;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        baenang = new int[N][2];
        for(int i = 0; i < N; i++){
            baenang[i][0] = sc.nextInt();
            baenang[i][1] = sc.nextInt();
        }
        max = 0;
        dfs(0, 0, 0);
        System.out.println(max);
    }
    public static void dfs(int depth, int W, int V){
        if(depth == N){
            max = Math.max(max, V);
            return;
        }
        if(W + baenang[depth][0] <= K)
            dfs(depth + 1, W + baenang[depth][0], V + baenang[depth][1]);

        if(W <= K)
            dfs(depth + 1, W, V);
    }
}
