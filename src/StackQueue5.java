import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42585
*/

class StackQueue5 {
    public int solution(String arrangement) {
        int answer = 0;
        int stackNow = 0; // 막대기의 개수
        Stack<Character> stack = new Stack<>();
        
        arrangement = arrangement.replace("()", "0"); // 레이저 "()"를 "0"으로 변환
        
        for(int i = 0; i < arrangement.length(); i++) {
            char temp = arrangement.charAt(i);
            
            switch(temp) {
                case '0': // 레이저
                    answer += stackNow;
                    break;
                case '(':
                    stack.push('(');
                    stackNow++;
                    break;
                case ')':
                    stack.pop();
                    stackNow--;
                    answer += 1;
                    break;
            }
        }
        
        return answer;
    }
}