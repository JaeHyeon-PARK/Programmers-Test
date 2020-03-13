import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42626
*/

class Heap1 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> prq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++)
            prq.add(scoville[i]);
        
        while(true) {
            int n1 = prq.poll();
            int n2 = prq.poll();
            int temp = n1 + (n2 * 2);
            answer++;
            
            if(temp >= K) break;
            else prq.add(temp);
        }
        
        return answer;
    }
}