import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42584
*/

class StackQueue6 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
            int time = 0;
            
            for(int j = i + 1; j < prices.length; j++) {
                if(prices[i] > prices[j]) {
                    time++;
                    break;
                }
                time++;
            }
            answer[i] = time;
        }
        
        return answer;
    }
}