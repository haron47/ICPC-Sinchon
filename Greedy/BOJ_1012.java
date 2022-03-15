import java.util.*;

public class BOJ_1012 {

    static int[][] map;
    static int M, N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T > 0) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            map = new int[M][N];
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
            }

            int answer = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(answer);

            T--;
        }
    }

    public static void dfs(int i, int j) {
        if ((i + 1 <= M - 1) && map[i + 1][j] == 1) {
            map[i + 1][j] = 0;
            dfs(i + 1, j);
        }
        if ((i - 1 >= 0) && map[i - 1][j] == 1) {
            map[i - 1][j] = 0;
            dfs(i - 1, j);
        }
        if ((j + 1 <= N - 1) && map[i][j + 1] == 1) {
            map[i][j + 1] = 0;
            dfs(i, j + 1);
        }
        if ((j - 1 >= 0) && map[i][j - 1] == 1) {
            map[i][j - 1] = 0;
            dfs(i, j - 1);
        }
    }
}
