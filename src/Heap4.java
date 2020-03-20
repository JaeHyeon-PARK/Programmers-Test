import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42628
*/

class Heap4 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        
        for(String operation : operations) {
            String[] splitOper = operation.split(" ");
            
            if(splitOper[0].equals("I")) {
                maxQ.add(Integer.parseInt(splitOper[1]));
                minQ.add(Integer.parseInt(splitOper[1]));
            }
            
            if(splitOper[0].equals("D")) {
                if(!maxQ.isEmpty() && !minQ.isEmpty()) {
                    if(splitOper[1].equals("1")) {
                        int max = maxQ.peek();
                        maxQ.remove(max);
                        minQ.remove(max);
                    }
                    else {
                        int min = minQ.peek();
                        maxQ.remove(min);
                        minQ.remove(min);
                    }
                }
            }
        }
        
        if(!maxQ.isEmpty() && !minQ.isEmpty()) {
            answer[0] = maxQ.peek();
            answer[1] = minQ.peek();
        }
        
        return answer;
    }
}