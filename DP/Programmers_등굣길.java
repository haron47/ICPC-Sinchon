public class 등굣길 {
    public static void main(String[]args){
        등굣길_Solution sol = new 등굣길_Solution();
        int m = 7;
        int n = 4;
        int[][] puddles = new int[][]{{2, 1}, {1, 2}};
        System.out.println(sol.solution(m, n, puddles));
    }
}

class 등굣길_Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        if(m == 1 || n == 1){
            if(puddles.length > 0)
                return 0;
            else if(puddles.length == 0)
                return 1;
        }

        int[][] path = new int[m + 1][n + 1];

        for(int i = 0; i < puddles.length; i++){
            path[puddles[i][0]][puddles[i][1]] = -1;
        }

        for(int i = 1; i <= m; i++){
            if(path[i][1] == -1){
                while(i <= m){
                    path[i][1] = -1;
                    i++;
                }
                break;
            }
            path[i][1] = 1;
        }

        for(int i = 1; i <= n; i++){
            if(path[1][i] == -1){
                while(i <= n){
                    path[1][i] = -1;
                    i++;
                }
                break;
            }
            path[1][i] = 1;
        }


        for(int i = 2; i <= m; i++){
            for(int j = 2; j <= n; j++){
                if(path[i][j] == -1)
                    continue;
                path[i][j] = ((int)Math.max(path[i - 1][j], 0) + (int)Math.max(path[i][j - 1], 0)) % 1000000007;
            }
        }

        answer = (int)Math.max(path[m][n], 0) % 1000000007;
        return answer;
    }
}