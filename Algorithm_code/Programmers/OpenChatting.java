package Programmers;

import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class OpenChatting {
	 static public String[] solution(String[] record) {
	        HashMap<String, String> user = new HashMap<>();
	        String[] logState = new String[100000];
	        String[] logId = new String[100000];
	        int j = 0;
	        for(int i = 0; i < record.length; i++) {
	        	String check = record[i];
	        	StringTokenizer st = new StringTokenizer(check, " ");
	        	String command = st.nextToken();
	        	if(command.equals("Enter")) {
	        		String id = st.nextToken();
	        		String nick = st.nextToken();
	        		user.put(id, nick);
	        		logId[j] = id;
	        		logState[j] = "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
	        		j++;
	        	} else if(command.equals("Leave")) {
	        		String id = st.nextToken();
	        		logId[j] = id;
	        		logState[j] = "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
	        		j++;
	        	} else if(command.equals("Change")){
	        		String id = st.nextToken();
	        		String nick = st.nextToken();
	        		user.put(id, nick);
	        	}
	        }
	        String answer[] = new String[j];
	        for(int i = 0; i < j ; i++) {
	        	answer[i] = user.get(logId[i])+logState[i];
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
