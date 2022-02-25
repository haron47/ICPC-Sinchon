import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer>  results = new ArrayList<Integer> ();

        for(int i = progresses.length - 1; i >= 0; i--){
            int remains = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            stack.push(remains);
        }


        int top = 0;
        while(!stack.empty()){
            int work = 1;
            top = Math.max(stack.pop(), top);
            if(stack.empty()){
                results.add(work);
                break;
            }
            if(stack.peek() <= top){
                while(stack.peek() <= top){
                    stack.pop();
                    work++;
                    if(stack.empty()){
                        break;
                    }
                }
            }
            results.add(work);
        }
        if(!stack.empty())
            results.add(1);
        int length = results.size();
        answer = new int[length];
        for(int i = 0;i < length; i++){
            answer[i] = results.get(i);
        }
        return answer;
    }
}
