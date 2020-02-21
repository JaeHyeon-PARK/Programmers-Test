import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42578
*/

class Hash3 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            if(!map.containsKey(key))
                map.put(key, 1);
            else
                map.put(key, map.get(key) + 1);
        }
        
        Iterator<Integer> it;
		Collection<Integer> values = map.values();
		it = values.iterator();
        
        while(it.hasNext()) {
            Integer value = it.next();
            answer *= value + 1;
        }
        
        return answer - 1;
    }
}