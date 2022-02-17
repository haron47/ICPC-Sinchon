import java.util.*;
class Solution {
    static char[] numsCArr;
    static ArrayList<Integer> numsArr;

    public int solution(String numbers) {
        int answer = 0;
        numsCArr = numbers.toCharArray();

        numsArr = new ArrayList<>();

        for ( int i=1; i<=numsCArr.length; i++){
            permutation(0, i);
        }

        for( int i=0; i<numsArr.size(); i++ ){
            if (!decimal(numsArr.get(i))){
                answer++;
            }
        }

        return answer;
    }

    public void permutation(int depth, int length){

        if( depth == length ){
            StringBuffer sb = new StringBuffer();
            for ( int i=0; i<length; i++){
                sb.append( numsCArr[i] );
            }

            if( !numsArr.contains(Integer.parseInt( sb.toString())) && Integer.parseInt( sb.toString()) > 1 ){
                numsArr.add( Integer.parseInt( sb.toString() ));
            }

            return;
        }

        for ( int i=depth; i<numsCArr.length; i++){
            swap(i, depth);
            permutation(depth+1, length);

            swap(i, depth);
        }
    }

    public void swap (int i, int j){
        char tmp = numsCArr[i];
        numsCArr[i] = numsCArr[j];
        numsCArr[j] = tmp;
    }

    public boolean decimal(int num) {
        boolean decimal = false;
        for ( int i=2; i<num; i++ ){
            if( num % i == 0 ){
                decimal = true;
                break;
            }
        }
        return decimal;
    }
}