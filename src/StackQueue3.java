import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42586
*/

class Solution {
    public int[] StackQueue3(int[] progresses, int[] speeds) {
        int idx = 0;
        int[] answer = {};
        Queue<Integer> q = new LinkedList<Integer>(); // �� ����� �Ϸ�� �� ���� �ɸ��� ��¥
        ArrayList<Integer> arr = new ArrayList<Integer>(); // �� ����� ������ ��¥
        ArrayList<Integer> ans = new ArrayList<Integer>(); // ����� ����� �迭 ����Ʈ
        
        for(int i = 0; i < progresses.length; i++) { // �� ����� �ɸ��� �� ���
            int day = (int)Math.ceil((double)(100 - progresses[i]) / (double)speeds[i]);
            q.add(day);
        }
        
        for(int i = 0; i < progresses.length; i++) { // ���߼ӵ��� ���� ���� �ݿ�
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
        
        for(int i = 0; i < arr.size(); i++) { // ���� �迭 ���
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
        
        answer = new int[ans.size()]; // ArrayList�� �迭�� ��ȯ
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}