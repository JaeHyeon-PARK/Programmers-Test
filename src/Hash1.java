import java.util.*;

/*
 Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42576
*/

class Hash1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0;i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            } else {
                answer = participant[i+1];
            }
        }
        return answer;
    }
}
