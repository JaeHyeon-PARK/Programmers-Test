import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42629
*/

class Heap2 {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int idx = 0;
        PriorityQueue<Integer> prq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < k; i++) {
            if(idx < dates.length && dates[idx] == i)
                prq.add(supplies[idx++]);
            
            if(stock == 0) {
                stock += prq.poll();
                answer++;
            }
            stock -= 1;
        }
        
        return answer;
    }
}