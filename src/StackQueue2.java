import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42583
*/

class StackQueue2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    	int answer = 0; // 총 걸린 시간
    	int sum = 0; // 현재 다리 무게
    	int pos = 0; // 다음에 건널 트럭의 배열값
    	int size = truck_weights.length; // 건널 트럭의 수
        
    	Queue<Integer> q = new LinkedList<Integer>(); // 다리 위의 트럭
    	ArrayList<Integer> arr = new ArrayList<Integer>(); // 다리를 지난 트럭
    	int[] time = new int[size]; // 각 트럭이 다리 위에서 이동한 시간
        
    	while(true) {
    		// 새 트럭이 다리 위로 올라가는 과정
    		answer++;
    		if((pos < size) && ((truck_weights[pos] + sum) <= weight)) {
    				q.add(truck_weights[pos]);
    				sum += truck_weights[pos];
                    pos++;
    		}
            
    		// 현재 다리 위에 있는 트럭들의 시간 배열 증가
    		for(int i = 0; i < pos; i++) {
    			if(time[i] != -1) // -1은 다리를 지난 트럭
    				time[i]++;
    		}
            
            for(int i = 0; i < pos; i++) {
                if(time[i] == bridge_length) { // 다리 길이와 시간이 같을 경우 목록에서 제외
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