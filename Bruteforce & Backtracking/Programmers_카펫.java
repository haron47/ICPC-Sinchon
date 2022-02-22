import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int yellowHeight = 1;
        int yellowWidth = yellow;
        while(yellowWidth >= yellowHeight){
            if(yellow % yellowWidth != 0){
                yellowWidth--;
                continue;
            }
            yellowHeight = yellow / yellowWidth;
            if(brown == calculateBrown(yellowHeight, yellowWidth)){
                answer[0] = yellowWidth + 2;
                answer[1] = yellowHeight + 2;
                break;
            }
            yellowWidth--;
        }
        return answer;
    }
    public int calculateBrown(int height, int width){
        int brownSqure = 0;
        brownSqure = 2 * height + 2 * width + 4;
        return brownSqure;
    }
}