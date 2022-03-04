import java.util.*;

public class BOJ_11399 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] people = new int[n];

        for(int i= 0; i < n; i++)
            people[i] = sc.nextInt();

        Arrays.sort(people);
        int[] time = new int[n];

        int sum = people[0];
        time[0] = people[0];
        for(int i= 1; i < n; i++){
            time[i] = people[i] + time[i - 1];
            sum += time[i];
        }
        System.out.println(sum);
    }
}
