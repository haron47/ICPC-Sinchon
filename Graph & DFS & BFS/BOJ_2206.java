import java.util.*;

public class BOJ_2206 {
    static int N, M, minValue;
    static int[][] map;
    static boolean[][][] check;
    static int[] x = { -1, 1, 0, 0 };
    static int[] y = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        check = new boolean[N][M][2];
        minValue = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            String input = sc.next();
            for(int j = 0; j < M; j++)
                map[i][j] = input.charAt(j) - '0';
        }

        bfs();

        if(minValue == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(minValue);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0, 1, 0 });

        while (!queue.isEmpty()) {
            int location[] = queue.poll();

            int count = location[2];
            int breakWall = location[3];
            if (location[0] == N - 1 && location[1] == M - 1) {
                minValue = Math.min(minValue, count);		// 마지막 위치에 도달했을 때 지나온 칸 수를 return
            }

            for (int direction = 0; direction < 4; direction++) {
                int r = location[0] + x[direction];
                int c = location[1] + y[direction];

                if (r < 0 || r >= N || c < 0 || c >= M)
                    continue;
                if (map[r][c] == 1 && breakWall == 1)	// 지나온 벽이 있고 다음 칸도 벽이면 진행 X
                    continue;

                if (breakWall == 1) {
                    if (!check[r][c][breakWall] && map[r][c] == 0) {
                        check[r][c][breakWall] = true;
                        queue.offer(new int[] { r, c, count + 1, breakWall});
                    }
                } else { // 벽을 안부순 상태
                    if (!check[r][c][breakWall] && map[r][c] == 1) {
                        check[r][c][breakWall] = true;
                        queue.offer(new int[] { r, c, count + 1, breakWall + 1 });
                    } else if (!check[r][c][breakWall] && map[r][c] == 0) {
                        check[r][c][breakWall] = true;
                        queue.offer(new int[] { r, c, count + 1, breakWall });
                    }
                }
            }
        }
    }
}