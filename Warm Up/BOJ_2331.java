import java.util.*;

public class BOJ_2331 {
    static int A, P;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        P = sc.nextInt();

        ArrayList<Integer> nums = new ArrayList<Integer>();


        int res = 0;
        int now = A;
        nums.add(now);
        while(true){
            res = pow(now, P);
            if(nums.contains(res))
                break;
            nums.add(res);
            now = res;
        }

        int ans = 0;
        for(int i = 0; i < nums.size(); i++){
            now = nums.get(i);
            if(now == res)
                break;
            ans++;
        }
        System.out.println(ans);
    }

    public static int pow(int num, int p){
        int temp = 1;
        int sum = 0;
        while(num > 0){
            temp = num % 10;
            sum += Math.pow(temp, p);
            num /= 10;
        }
        return sum;
    }
}
