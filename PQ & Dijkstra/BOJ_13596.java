import java.util.*;

public class BOJ_13596 {
    static int n;
    static int m;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }

    static void dijkstra(int start){
        dist[start] = 0;
        Node node = new Node(start,0);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(node);

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int to = cur.to;
            int time = cur.time;


            if(visited[to]) continue;
            else{
                visited[to] = true;
                ArrayList<Node> nextList = list.get(to);

                for(int i=0;i<nextList.size();i++){
                    Node temp = nextList.get(i);
                    if(dist[temp.to] > dist[to] + temp.time){
                        dist[temp.to] = dist[to] + temp.time;
                        pq.add(new Node(temp.to,dist[temp.to]));
                    }
                }
            }

        }
    }
    static class Node implements Comparable<Node>{
        int to,time;
        public Node(int to,int time){
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}

