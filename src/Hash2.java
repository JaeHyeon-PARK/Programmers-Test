import java.util.*;

/*
Question's URL: https://programmers.co.kr/learn/courses/30/lessons/42577
*/

class Hash2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for(int i = 0; i < phone_book.length - 1; i++) {
            for(int j = i + 1; j < phone_book.length; j++) {
                if(phone_book[j].startsWith(phone_book[i])) return false;
                if(phone_book[i].startsWith(phone_book[j])) return false;
            }
        }
        
        return answer;
    }
}