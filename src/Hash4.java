import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42579
*/

class Hash4 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<Integer>();
        
        HashMap<String, Integer> gpMap = new HashMap<String, Integer>(); // 장르-장르별 재생횟수 해쉬맵
        for(int i = 0; i < genres.length; i++)
            gpMap.put(genres[i], gpMap.getOrDefault(genres[i], 0) + plays[i]);
        
        Set<String> key = gpMap.keySet();
        HashMap<Integer, String> pgMap = new HashMap<Integer, String>(); // 장르별 재생횟수-장르 해쉬맵
        for(String k : key)
            pgMap.put(gpMap.get(k), k);
        
        TreeMap<Integer,String> tm = new TreeMap<Integer,String>(pgMap); // 장르별 재생횟수-장르 해쉬맵을 키 오름차순 정렬
        int tmSize = tm.size();
        for(int i = 0; i < tmSize; i++) {
            String genre = tm.lastEntry().getValue();
            Integer playCount = tm.lastEntry().getKey();
            
            int firstPlay = -1, secondPlay = -1;
            int firstIdx = -1, secondIdx = -1;
            
            for(int j = 0; j < genres.length; j++) { // 가장 큰 노래 탐색
                if(genres[j].equals(genre)) {
                    if(plays[j] > firstPlay) {
                        firstPlay = plays[j];
                        firstIdx = j;
                    }
                }
            }
            
            // 가장 큰 노래를 각 배열에서 제거 및 답에 추가
            genres[firstIdx] = "-1";
            plays[firstIdx] = -1;
            answerList.add(firstIdx);
            
            for(int j = 0; j < genres.length; j++) { // 두번째로 큰 노래 탐색
                if(genres[j].equals(genre)) {
                    if(plays[j] > secondPlay) {
                        secondPlay = plays[j];
                        secondIdx = j;
                    }
                }
            }
            
            // 두 번째 큰 값을 각 배열에서 제거 및 답에 추가
            if(secondIdx != -1) { // 한 곡만 있을 경우 -1이 추가됨을 방지
                genres[secondIdx] = "-1";
                plays[secondIdx] = -1;
                answerList.add(secondIdx);
            }
            
            tm.remove(playCount); // 탐색 완료된 장르를 삭제
        }
        
        answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++)
            answer[i] = answerList.get(i);
        
        return answer;
    }
}