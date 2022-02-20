import java.util.*;

public class _1167 {
    static LinkedList<Pair> tree[];
    static int distance[], max, index;
    static boolean visited[];
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        tree = new LinkedList[V + 1];
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        
        for(int i = 1; i <= V; i++) 
        	tree[i] = new LinkedList<>();
        	
        for(int i = 1; i <= V; i++) {
        	int node1 = sc.nextInt();
        	while(true) {
        		int node2 = sc.nextInt();
        		if(node2 == -1)
        			break;
        		int weight = sc.nextInt();
        		tree[node1].add(new Pair(node2, weight));
        	}
        }
		dfs(1, 0);
		visited = new boolean[V + 1];
		distance = new int[V + 1];
		dfs(index, 0);
		System.out.println(max); 
    }
    
    public static void dfs(int node, int weight) {
        distance[node] = weight;
        visited[node] = true;
        
        if(weight > max) {
            max = weight;
            index = node;
        }
        
        for(Pair next : tree[node]) {
            if(!visited[next.num])
                dfs(next.num, weight + next.weight);
        }
    }
    
    static class Pair {
        int num, weight;
        Pair(int n, int w) {
            num = n;
            weight = w;
        }
    }
}