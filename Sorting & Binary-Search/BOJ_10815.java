import java.util.*;

public class BOJ_10815 {
    static int[] card;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        card = new int[N];
        for(int i = 0; i < N; i++)
            card[i] = sc.nextInt();

        int M = sc.nextInt();
        int[] nums = new int[M];
        for(int i = 0; i < M; i++)
            nums[i] = sc.nextInt();

        Arrays.sort(card);

        for(int i = 0; i < M ; i++){
            if(binarySearch(0, N - 1, nums[i]))
                System.out.print(1 + " ");
            else
                System.out.print(0 + " ");
        }

    }
    public static boolean binarySearch(int start, int end, int num){
        if(start <= end){
            int mid = (start + end) / 2;
            if(card[mid] == num)
                return true;
            else if(card[mid] > num)
                return binarySearch(start, mid - 1, num);
            else
                return binarySearch(mid + 1, end, num);
        }
        return false;
    }
}
