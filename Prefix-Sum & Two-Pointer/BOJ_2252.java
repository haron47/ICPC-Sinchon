import java.util.*;

public class BOJ_2252 {
    static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int[] in = new int[N + 1];
        ArrayList<Integer>[] out = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            out[i] = new ArrayList<Integer>();

        for(int i = 1; i <= M; i++){
            int first = sc.nextInt();
            int second = sc.nextInt();
            in[second]++;
            out[first].add(second);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 1; i <= N; i++)
            if (in[i] == 0) {
                queue.add(i);
            }

        ArrayList<Integer> res = new ArrayList<Integer>();

        while(!queue.isEmpty()){
            int now = queue.poll();
            res.add(now);

            for(int i = 0; i < out[now].size(); i++){
                int next = out[now].get(i);
                in[next]--;
                if(in[next] == 0)
                    queue.add(next);
            }
        }
        for(int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");
    }
}
