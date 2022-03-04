import java.util.*;

public class BOJ_1260 {
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, V;

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
        }
        dfs(V, N);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V, N);
    }
    public static void dfs(int start, int N){
        visited[start] = true;
        System.out.print(start + " ");
        for(int i = 1; i <= N; i++){
            if(graph[start][i] == 1 && !visited[i]){
                dfs(i, N);
            }
        }
    }

    public static void bfs(int start, int N){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now + " ");

            for(int i = 1; i <= N; i++){
                if(graph[now][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
