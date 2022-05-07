import java.util.*;
public class Programmers_3333 {

    public static void main(String[] args) {
        String s = "aaabba";
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int now = s.charAt(0);
        int num = 1;
        for(int i = 1; i < s.length(); i++){
            if(now != s.charAt(i)){
                answer.add(num);
                num = 1;
            }else{
                num++;
            }
            now = s.charAt(i);
        }
        answer.add(num);
        for(Integer i : answer) { 
            System.out.println(i);
        }
    }

}
