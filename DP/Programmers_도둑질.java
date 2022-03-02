public class 도둑질 {
    public static void main(String[]args){
        도둑질_Solution sol = new 도둑질_Solution();
        int[] money = new int[]{1, 2, 3, 1};
        System.out.println(sol.solution(money));
    }
}

class 도둑질_Solution {
    public int solution(int[] money) {
        int answer = 0;

        int[][] result = new int[money.length][2];


        result[0][1] = money[0];
        result[1][0] = money[1];
        result[1][1] = money[1];

        result[2][1] = money[0] + money[2];
        result[2][0] = money[2];

        for(int i = 3; i < money.length; i++){
            result[i][0] = (int)Math.max(result[i - 3][0], result[i - 2][0]) + money[i];
            result[i][1] = (int)Math.max(result[i - 3][1], result[i - 2][1]) + money[i];
        }

        int max = Math.max(result[money.length - 2][0], result[money.length - 1][0]);
        max = Math.max(result[money.length - 3][1], max);
        max = Math.max(result[money.length - 2][1], max);
        answer = max;
        return answer;
    }
}