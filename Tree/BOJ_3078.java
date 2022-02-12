import java.util.*;
import java.io.*;

public class _3078 {

    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());;
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
 
        long pair = 0;
 
        Queue<Integer> queue;
 
        List<Queue<Integer>> qlist = new ArrayList<>(19);
        for (int i = 0; i < 19; i++) 
        	qlist.add(new LinkedList<>());
 
        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(br.readLine());
            int l = -2;
            while (c > 32) 
            	l += 1;
            queue = qlist.get(l);
            while (!queue.isEmpty() && queue.peek() + K < i) 
            	queue.poll();
            pair += queue.size();
            queue.offer(i);
        }
        System.out.print(pair);
    }
}
