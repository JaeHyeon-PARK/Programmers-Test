import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42586
*/

class Solution {
    public int[] StackQueue3(int[] progresses, int[] speeds) {
        int idx = 0;
        int[] answer = {};
        Queue<Integer> q = new LinkedList<Integer>(); // 각 기능이 완료될 때 까지 걸리는 날짜
        ArrayList<Integer> arr = new ArrayList<Integer>(); // 각 기능이 배포될 날짜
        ArrayList<Integer> ans = new ArrayList<Integer>(); // 결과가 저장될 배열 리스트
        
        for(int i = 0; i < progresses.length; i++) { // 각 기능의 걸리는 일 계산
            int day = (int)Math.ceil((double)(100 - progresses[i]) / (double)speeds[i]);
            q.add(day);
        }
        
        for(int i = 0; i < progresses.length; i++) { // 개발속도에 따른 차이 반영
            if(i == 0) arr.add(q.poll());
            else {
                int day = q.poll();
                if(day < arr.get(i - 1)) {
                    day = arr.get(i - 1);
                    arr.add(day);
                }
                else {
                    arr.add(day);
                }
            }
        }
        
        for(int i = 0; i < arr.size(); i++) { // 리턴 배열 계산
            if(idx == 0) {
                ans.add(1);
                idx++;
            }
            else {
                if(arr.get(i) == arr.get(i - 1))
                    ans.set(idx - 1, ans.get(idx - 1) + 1);
                else {
                    ans.add(1);
                    idx++;
                }
            }
        }
        
        answer = new int[ans.size()]; // ArrayList를 배열로 변환
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}