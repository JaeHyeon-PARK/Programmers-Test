import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42587
*/

class StackQueue4 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int idx = 0;
        Queue<Integer> imp = new LinkedList<Integer>(); // 각 문서의 중요도 저장
        Queue<Integer> doc = new LinkedList<Integer>(); // 각 문서의 인덱스 저장
        ArrayList<Integer> printedImp = new ArrayList<Integer>(); // 인쇄된 문서의 중요도
        ArrayList<Integer> printedDoc = new ArrayList<Integer>(); // 인쇄된 문서의 인덱스
        
        for(int i = 0; i < priorities.length; i++) { // 큐에 중요도와 인덱스를 저장
            imp.add(priorities[i]);
            doc.add(i);
        }
        
        // 중요도에 따른 정렬 작업
        while(!imp.isEmpty()) {
            int tmpImp = imp.poll(); // 가장 앞에 있는 문서의 중요도
            int tmpDoc = doc.poll(); // 가장 앞에 있는 문서의 인덱스
            boolean isMax = true; // 최댓값 여부를 저장
            
            Iterator it = imp.iterator(); // 최댓값 여부를 순차 탐색
            while(it.hasNext()) {
                if(tmpImp < (int)it.next()) {
                    isMax = false;
                    break;
                }
            }
            
            if(isMax == true) { // 최댓값일 때
                printedImp.add(tmpImp);
                printedDoc.add(tmpDoc);
            }
            else { // 최댓값이 아닐 때
                imp.add(tmpImp);
                doc.add(tmpDoc);
            }
        }
        
        System.out.println(printedImp);
        System.out.println(printedDoc);
        
        Iterator it = printedDoc.iterator(); // location을 탐색
        while(it.hasNext()) {
            int tmpDoc = (int)it.next();
            
            if(location == tmpDoc) break;
            answer++;
        }
        
        return answer + 1;
    }
}