import java.util.*;

public class BOJ_13904 {
    static int N, max, day;
    static int[][] task;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        task = new int[N + 1][2];
        day = 0;

        for(int i = 1; i <= N; i++){
            task[i][0] = sc.nextInt();
            task[i][1] = sc.nextInt();
            day = Math.max(day, task[i][0]);
        }

        int temp = 0;
        int result = 0;

        for(int i = day; i >= 1; i--){
            max = 0;
            for(int j = 1; j <= N; j++){
                if(i <= task[j][0]){
                    if(max < task[j][1]){
                        max = task[j][1];
                        temp = j;
                    }
                }
            }
            result += max;
            task[temp][0] = -1;
        }
        System.out.println(result);
    }
}
