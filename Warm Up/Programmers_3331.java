public class Programmers_3331 {

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 3, 3};
        int max = 0;

        int[] num = new int[3];
        int[] answer = new int[3];
        for(int i = 0; i < arr.length; i++) {
            int now = arr[i] - 1;
            num[now]++;
            max = Math.max(max, num[now]);
        }
        for(int i = 0; i < answer.length; i++){
            answer[i] = max - num[i];
        }
        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}
