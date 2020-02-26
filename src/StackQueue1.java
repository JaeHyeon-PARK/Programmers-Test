import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42588
*/

class StackQueue1 {
    public int[] solution(int[] heights) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ansList = new ArrayList<>();
        
        for(int i = heights.length - 1; i >= 1; i--) {
            int res = 0;
            
            for(int j = i - 1; j >= 0; j--) {
                if(heights[j] > heights[i]) {
                    res = j + 1;
                    break;
                }
            }
            stack.push(res);
        }
        stack.push(0);
        
        while(!stack.isEmpty())
            ansList.add(stack.pop());
        
        answer = new int[ansList.size()];
        for(int i = 0; i < ansList.size(); i++)
            answer[i] = ansList.get(i);
        
        return answer;
    }
}