package Programmers;

import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class OpenChatting {
	 static public String[] solution(String[] record) {
	       HashMap<String, String> user = new HashMap<>();
	       String[] logId = new String[100000];
	       String[] logState = new String[100000];
	       int cnt = 0;
	       for(int i = 0; i < record.length; i++) {
	    	   StringTokenizer st = new StringTokenizer(record[i]);
	    	   String command = st.nextToken();
	    	   if(command.equals("Enter")) {
	    		   logId[cnt] = st.nextToken();
	    		   logState[cnt] = "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
	    		   String nick = st.nextToken();
	    		   user.put(logId[cnt], nick);
	    		   cnt++;
	    	   } else if(command.equals("Leave")) {
	    		   logId[cnt] = st.nextToken();
	    		   logState[cnt] = "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
	    		   cnt++;
	    	   } else if(command.equals("Change")) {
	    		   String id = st.nextToken();
	    		   String nick = st.nextToken();
	    		   user.put(id, nick);
	    	   }
	       }
	       String[] answer = new String[cnt];
	       for(int i = 0; i < cnt ; i++) {
	    	   String nick = user.get(logId[i]);
	    	   answer[i] = nick + logState[i];
	       }
	       return answer;
	    }
	 public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan","Enter uid1235 asdasd","Enter uid1225 xrodo"};
		String[] answer = solution(record);
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
