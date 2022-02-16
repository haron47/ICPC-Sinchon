import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] supoja1 = {1, 2, 3, 4, 5};
        int[] supoja2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoja3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int supoja1_score = 0;
        int supoja2_score = 0;
        int supoja3_score = 0;

        for(int i = 0; i < answers.length; i++){
            int supoja1_answer = i % 5;
            int supoja2_answer = i % 8;
            int supoja3_answer = i % 10;

            if(answers[i] == supoja1[supoja1_answer])
                supoja1_score++;
            if(answers[i] == supoja2[supoja2_answer])
                supoja2_score++;
            if(answers[i] == supoja3[supoja3_answer])
                supoja3_score++;
        }

        int max_score = supoja1_score;
        if(supoja2_score > max_score)
            max_score = supoja2_score;
        if(supoja3_score > max_score)
            max_score = supoja3_score;

        List<Integer> result = new ArrayList<Integer>();
        int idx = 0;
        if(max_score == supoja1_score)
            result.add(idx + 1);
        idx++;
        if(max_score == supoja2_score)
            result.add(idx + 1);
        idx++;
        if(max_score == supoja3_score)
            result.add(idx + 1);

        int resultSize = result.size();
        int answer[] = new int[resultSize];
        for(int i = 0; i < resultSize; i++)
            answer[i] = result.get(i);

        return answer;
    }
}
