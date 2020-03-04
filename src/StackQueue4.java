import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42587
*/

class StackQueue4 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int idx = 0;
        Queue<Integer> imp = new LinkedList<Integer>(); // �� ������ �߿䵵 ����
        Queue<Integer> doc = new LinkedList<Integer>(); // �� ������ �ε��� ����
        ArrayList<Integer> printedImp = new ArrayList<Integer>(); // �μ�� ������ �߿䵵
        ArrayList<Integer> printedDoc = new ArrayList<Integer>(); // �μ�� ������ �ε���
        
        for(int i = 0; i < priorities.length; i++) { // ť�� �߿䵵�� �ε����� ����
            imp.add(priorities[i]);
            doc.add(i);
        }
        
        // �߿䵵�� ���� ���� �۾�
        while(!imp.isEmpty()) {
            int tmpImp = imp.poll(); // ���� �տ� �ִ� ������ �߿䵵
            int tmpDoc = doc.poll(); // ���� �տ� �ִ� ������ �ε���
            boolean isMax = true; // �ִ� ���θ� ����
            
            Iterator it = imp.iterator(); // �ִ� ���θ� ���� Ž��
            while(it.hasNext()) {
                if(tmpImp < (int)it.next()) {
                    isMax = false;
                    break;
                }
            }
            
            if(isMax == true) { // �ִ��� ��
                printedImp.add(tmpImp);
                printedDoc.add(tmpDoc);
            }
            else { // �ִ��� �ƴ� ��
                imp.add(tmpImp);
                doc.add(tmpDoc);
            }
        }
        
        System.out.println(printedImp);
        System.out.println(printedDoc);
        
        Iterator it = printedDoc.iterator(); // location�� Ž��
        while(it.hasNext()) {
            int tmpDoc = (int)it.next();
            
            if(location == tmpDoc) break;
            answer++;
        }
        
        return answer + 1;
    }
}