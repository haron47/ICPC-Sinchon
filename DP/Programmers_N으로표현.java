public class DP_N으로표현 {
    public static void main(String[]args){
        Solution sol = new Solution();
        int N = 2;
        int number = 11;
        System.out.println(sol.solution(N, number));
    }
}

class Solution {
    static int min = Integer.MAX_VALUE;
    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return min;
    }

    public void dfs(int n, int number, int now, int depth){
        if(now == number){
            min = Math.min(min, depth);
            return;
        }
        if(depth > 8)
            return;
        int sum = 0;
        for(int i = 0; i < 8; i++){
            if(depth + i > 8)
                continue;
            sum = sum * 10 + n;
            dfs(n, number, now + sum, depth + i + 1);
            dfs(n, number, now - sum, depth + i + 1);
            dfs(n, number, now / sum, depth + i + 1);
            dfs(n, number, now * sum, depth + i + 1);
        }
    }
}
