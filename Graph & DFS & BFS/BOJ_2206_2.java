import java.util.*;

public class BOJ_2206_2 {

    static int N, M, minValue;
    static int[][] map;
    static boolean[][][] check;
    static int[] x = {-1, 1, 0, 0};
    static int[] y = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N + 1][M + 1];
        check = new boolean[N + 1][M + 1][2];
        minValue = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            String input = sc.next();
            for (int j = 1; j <= M; j++) {
                map[i][j] = input.charAt(j - 1) - '0';
            }
        }
        bfs();
        if (minValue == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minValue);
        }
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{1, 1, 1, 0});

        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            int count = location[2];
            int wall = location[3];
            if (location[0] == N && location[1] == M) {
                minValue = Math.min(minValue, count);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int X = location[0] + x[i];
                int Y = location[1] + y[i];

                if (X > N || Y > M || X < 1 || Y < 1) {
                    continue;
                }
                if (map[X][Y] == 1 && wall == 1) {
                    continue;
                }

                if (wall == 1) {
                    if (!check[X][Y][wall] && map[X][Y] == 0) {
                        check[X][Y][wall] = true;
                        queue.offer(new int[]{X, Y, count + 1, wall});
                    }
                } else {
                    if (!check[X][Y][wall] && map[X][Y] == 1) {
                        check[X][Y][wall] = true;
                        queue.offer(new int[]{X, Y, count + 1, wall + 1});
                    } else if (!check[X][Y][wall] && map[X][Y] == 0) {
                        check[X][Y][wall] = true;
                        queue.offer(new int[]{X, Y, count + 1, wall});
                    }
                }
            }
        }
    }
}
