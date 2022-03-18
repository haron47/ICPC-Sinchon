import java.util.*;

public class BOJ_13591 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] word = new String[N + 1];

        for(int i = 0; i < N; i++){
            word[i] = sc.next();
        }

        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            String result = sc.next();
            int ans = 0;
            for(int j = 0; j < N; j++){
                if(compareString(word[j], result))
                    ans++;
            }
            System.out.println(ans);
        }
    }
    public static boolean compareString(String word, String result){
        if(word.length() < result.length())
            return false;
        for(int i = 0; i < result.length(); i++){
            if(word.charAt(i) != result.charAt(i))
                return false;
        }
        return true;
    }
}
