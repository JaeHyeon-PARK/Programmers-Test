import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42583
*/

class StackQueue2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    	int answer = 0; // �� �ɸ� �ð�
    	int sum = 0; // ���� �ٸ� ����
    	int pos = 0; // ������ �ǳ� Ʈ���� �迭��
    	int size = truck_weights.length; // �ǳ� Ʈ���� ��
        
    	Queue<Integer> q = new LinkedList<Integer>(); // �ٸ� ���� Ʈ��
    	ArrayList<Integer> arr = new ArrayList<Integer>(); // �ٸ��� ���� Ʈ��
    	int[] time = new int[size]; // �� Ʈ���� �ٸ� ������ �̵��� �ð�
        
    	while(true) {
    		// �� Ʈ���� �ٸ� ���� �ö󰡴� ����
    		answer++;
    		if((pos < size) && ((truck_weights[pos] + sum) <= weight)) {
    				q.add(truck_weights[pos]);
    				sum += truck_weights[pos];
                    pos++;
    		}
            
    		// ���� �ٸ� ���� �ִ� Ʈ������ �ð� �迭 ����
    		for(int i = 0; i < pos; i++) {
    			if(time[i] != -1) // -1�� �ٸ��� ���� Ʈ��
    				time[i]++;
    		}
            
            for(int i = 0; i < pos; i++) {
                if(time[i] == bridge_length) { // �ٸ� ���̿� �ð��� ���� ��� ��Ͽ��� ����
    				time[i] = -1;
    				int complete = q.poll();
    				sum -= complete;
    				arr.add(complete);
    			}
            }
            
            if(arr.size() == truck_weights.length) {
    			answer++;
    			break;
    		}
    	}
    	return answer;
    }
}