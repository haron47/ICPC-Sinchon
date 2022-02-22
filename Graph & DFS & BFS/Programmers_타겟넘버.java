import java.util.*;

class Solution {
    static int[] visited;
    static int length;
    static int[][] number;
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        length = numbers.length;

        number = new int[length][2];
        for(int i = 0; i < length; i++){
            number[i][0] = numbers[i];
            number[i][1] = numbers[i] * (-1);
        }
        dfs(0, 0, target);

        return answer;
    }
    public void dfs(int depth, int result, int target){
        if(depth == length){
            if(result == target)
                answer++;
            return;
        }
        for(int i = 0; i < 2; i++){
            dfs(depth + 1, result + number[depth][i], target);
        }
    }
}