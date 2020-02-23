import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42579
*/

class Hash4 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<Integer>();
        
        HashMap<String, Integer> gpMap = new HashMap<String, Integer>(); // �帣-�帣�� ���Ƚ�� �ؽ���
        for(int i = 0; i < genres.length; i++)
            gpMap.put(genres[i], gpMap.getOrDefault(genres[i], 0) + plays[i]);
        
        Set<String> key = gpMap.keySet();
        HashMap<Integer, String> pgMap = new HashMap<Integer, String>(); // �帣�� ���Ƚ��-�帣 �ؽ���
        for(String k : key)
            pgMap.put(gpMap.get(k), k);
        
        TreeMap<Integer,String> tm = new TreeMap<Integer,String>(pgMap); // �帣�� ���Ƚ��-�帣 �ؽ����� Ű �������� ����
        int tmSize = tm.size();
        for(int i = 0; i < tmSize; i++) {
            String genre = tm.lastEntry().getValue();
            Integer playCount = tm.lastEntry().getKey();
            
            int firstPlay = -1, secondPlay = -1;
            int firstIdx = -1, secondIdx = -1;
            
            for(int j = 0; j < genres.length; j++) { // ���� ū �뷡 Ž��
                if(genres[j].equals(genre)) {
                    if(plays[j] > firstPlay) {
                        firstPlay = plays[j];
                        firstIdx = j;
                    }
                }
            }
            
            // ���� ū �뷡�� �� �迭���� ���� �� �信 �߰�
            genres[firstIdx] = "-1";
            plays[firstIdx] = -1;
            answerList.add(firstIdx);
            
            for(int j = 0; j < genres.length; j++) { // �ι�°�� ū �뷡 Ž��
                if(genres[j].equals(genre)) {
                    if(plays[j] > secondPlay) {
                        secondPlay = plays[j];
                        secondIdx = j;
                    }
                }
            }
            
            // �� ��° ū ���� �� �迭���� ���� �� �信 �߰�
            if(secondIdx != -1) { // �� � ���� ��� -1�� �߰����� ����
                genres[secondIdx] = "-1";
                plays[secondIdx] = -1;
                answerList.add(secondIdx);
            }
            
            tm.remove(playCount); // Ž�� �Ϸ�� �帣�� ����
        }
        
        answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++)
            answer[i] = answerList.get(i);
        
        return answer;
    }
}