class Solution {
    static int min;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(words));
        if(!wordList.contains(target))
            return 0;

        min = 100;
        for(int i = 0; i < words.length; i++){
            boolean[] visited = new boolean[words.length];
            if(sameChar(begin, words[i]) < begin.length() - 1) continue;
            visited[i] = true;
            dfs(begin, i, target, words, visited);
        }


        if(min == 100){
            answer = 0;
        }else{
            answer = min;
        }
        System.out.println(answer);
        return answer;
    }
    public void dfs(String prev, int now, String target, String[] words, boolean[] visited){
        if(words[now].equals(target)){
            int result = 0;
            for(int i = 0; i < words.length; i++){
                if(visited[i]){
                    result++;
                }
            }
            if(result > 0) min = Math.min(min, result);
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(sameChar(words[now], words[i]) >= prev.length() - 1 && !visited[i]){
                visited[i] = true;
                dfs(words[now], i, target, words, visited);
                visited[i] = false;
            }
        }

    }
    public int sameChar(String str1, String str2){
        int sameCharNum = 0;
        for(int i = 0; i < str1.length(); i++)
            if(str1.charAt(i) == str2.charAt(i))
                sameCharNum++;
        return sameCharNum;
    }
}