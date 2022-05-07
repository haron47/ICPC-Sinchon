import java.util.*;
import java.util.Map.Entry;

public class Programmers_02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

    public static boolean option1(String password) {
        if (password.length() >= 8 && password.length() <= 15) {
            return true;
        }
        return false;
    }

    public static int option23(String password) {
        int[] cnt = new int[4];
        int res = 0;

        boolean flag = false;
        for (int i = 0; i < password.length(); i++) {
            char now = password.charAt(i);

            flag = false;

            if (now >= 'A' && now <= 'Z') {
                cnt[0]++;
                flag = true;
            }

            if (now >= 'a' && now <= 'z') {
                cnt[1]++;
                flag = true;
            }

            if (now >= 0 && now <= 9) {
                cnt[2]++;
                flag = true;
            }
            if (now == '~' || now == '!') {
                cnt[3]++;
                flag = true;
            }

            if (!flag) {
                return 0;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (cnt[i] > 0) {
                res++;
            }
        }
        return res;
    }

    public static boolean option4(String password) {
        char prev = password.charAt(0);

        int cnt = 1;

        for (int i = 1; i < password.length(); i++) {
            if (prev == password.charAt(i)) {
                cnt++;
            } else {
                prev = password.charAt(i);
                cnt = 1;
            }
            if (cnt >= 4) {
                return false;
            }
        }
        return true;
    }

    public static boolean option5(String password) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < password.length(); i++) {
            if (map.containsKey(password.charAt(i))) {
                int num = map.get(password.charAt(i));
                map.put(password.charAt(i), num + 1);
            } else {
                map.put(password.charAt(i), 1);
            }
        }

        Iterator<Entry<Character, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<Character, Integer> entrySet = (Entry<Character, Integer>) it.next();
            if (entrySet.getValue() >= 5) {
                return false;
            }
        }

        return true;
    }
}
