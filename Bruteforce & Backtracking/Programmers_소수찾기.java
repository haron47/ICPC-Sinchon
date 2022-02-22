import java.util.*;
class Solution {
    static char[] numbersToChar;
    static ArrayList<Integer> result;
    static int length;
    public int solution(String numbers) {
        int answer = 0;

        numbersToChar = numbers.toCharArray();
        length = numbers.length();
        result = new ArrayList<Integer>();

        for(int i = 1; i <= length; i++){
            permutation(0, i);
        }
        for(int i = 0; i < result.size(); i++){
            if(idDecimal(result.get(i))){
                answer++;
            }
        }
        return answer;
    }

    public void permutation(int start, int depth){
        if(start == depth){
            int number = 0;
            for(int i = 0; i < depth; i++){
                if(numbersToChar[i] == '0')
                    continue;
                Math.pow(10, depth - (i + 1));
                number += Math.pow(10, depth - (i + 1)) * (numbersToChar[i] - '0');
            }
            if(number != 0 && !result.contains(number))
                result.add(number);
            return;
        }

        for(int i = start; i < length; i++){
            swap(start, i);
            permutation(start + 1, depth);
            swap(start, i);
        }
    }
    public void swap(int n, int m){
        char temp = numbersToChar[n];
        numbersToChar[n] = numbersToChar[m];
        numbersToChar[m] = temp;
    }

    public boolean idDecimal(int num){
        boolean isPrime = true;
        if(num == 1) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime) return true;
        else return false;
    }
}