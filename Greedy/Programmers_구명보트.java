import java.util.Arrays;

public class 구명보트 {
    public static void main(String[] args) {
        Solution_구명보트 s = new Solution_구명보트();
        int[] people = {10,20,30,40,50,60,70,80,90};
        int limit = 100;
        System.out.println(s.solution(people, limit));
    }
}

class Solution_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int boat = 0;
        int max = 0;

        int light = people[0];
        for(int i = people.length - 1; i > 0; i--){
            if(people[i] == 0)
                continue;
            int remain = limit - people[i];
            if(light + people[i] > limit)
                continue;
            for(int j = i - 1; j >= 0; j--){
                if(people[j] <= remain && people[j] != 0){
                    people[i] = 0;
                    people[j] = 0;
                    boat++;
                    break;
                }
            }
        }
        for(int i = 0; i < people.length; i++)
            if(people[i] > 0)
                boat++;
        return boat;
    }
}