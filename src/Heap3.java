import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42627
*/

public class Job implements Comparable<Job> {
    int start;
    int workTime;
    
    public Job(int start, int time) {
        this.start = start;
        this.workTime = time;
    }
    
    //�۾� �ð��� ª������, ���� �ð��� ª�� ���� �켱������ ����
    @Override
    public int compareTo(Job o) {
        if (this.workTime < o.workTime) return -1;
        else if (this.workTime == o.workTime) {
            if (this.start < o.start) return -1;
            else return 1;
        }
        else return 1;
    }
}

class Heap3 {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Job> prq = new PriorityQueue<>();
        List<Job> list = new ArrayList<>();
        
        for(int i = 0; i < jobs.length; i++)
            prq.add(new Job(jobs[i][0], jobs[i][1]));
        
        for (int i = 0; i < jobs.length; i++)
            list.add(prq.poll());
        
        int time = 0; // ���� �ð�
        int sum = 0; // �ɸ� �ð����� ��
        while(list.size() > 0) {
            for(int i = 0; i < list.size(); i++) {
                if(time >= list.get(i).start) {
                    time += list.get(i).workTime;
                    sum += time - list.get(i).start;
                    list.remove(i);
                    break;
                }
                
                if(i == list.size() - 1) time++;
            }
        }
        
        answer = (sum / jobs.length);
        return answer;
    }
}