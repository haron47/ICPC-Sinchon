class Solution {
    static int[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];

        for(int i = 0; i < n; i++)
            dfs(i, 1, n, computers);

        for(int i = 0; i < n; i++)
            if(visited[i] == 1)
                answer++;

        return answer;
    }
    public void dfs(int start, int idx, int n, int[][] computers){
        if(visited[start] != 0)
            return;

        visited[start] = idx;
        idx++;
        for(int i = 0; i < n; i++){
            if(computers[start][i] == 1 && visited[i] == 0)
                dfs(i, idx, n, computers);
        }
    }
}