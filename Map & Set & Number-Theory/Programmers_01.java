import java.util.*;

public class Programmers_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer>[] score = new HashMap[5];

        int[] result = new int[5];

        for (int i = 0; i < 5; i++) {
            score[i] = new HashMap<String, Integer>();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > 0; j--) {
                String language = sc.next();
                score[i].put(language, j);
            }
        }

        int N = sc.nextInt();
        String[] languages = new String[N];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < N; j++) {
                if (score[i].containsKey(languages[i])) {
                    result[i] += score[i].get(languages[i]);
                }
            }
        }

        int max = 0;
        int idx = 0;

        for (int i = 0; i < 5; i++) {
            if (max < result[i]) {
                idx = i;
            }
        }
        System.out.println(idx);
    }
}
