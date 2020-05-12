package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
class Solution {
  public int[] solution(String msg) {
      int[] answer = {};
       ArrayList<Integer> list = new ArrayList<>();
	      Map<String, Integer> map = new HashMap<>();
	      
	      int cnt = 1;
	      for(int i = 65; i <= 90; i++) {
	    	  char ch = (char)i;
	    	  map.put(String.valueOf(ch),cnt );  
	    	  cnt++;
	      }
	      cnt--;
	      
	      boolean run = true;
	      while(run) {
	    	  for(int i = msg.length(); i > 0; i--) {
	    		  String s = msg;
	    		  s = msg.substring(0,i);
	    		  if(map.containsKey(s)) {
	    			  list.add(map.get(s));
	    			  cnt++;
	    			  
	    			  if(i != msg.length()) {
	    				  s = msg.substring(0,i+1);	    				  
	    			  }
	    			  
	    			  map.put(s, cnt);
	    			  msg = msg.substring(i,msg.length());
	    			  break;
	    		  }	    		  
	    	  }
	    	  if(msg.equals("")) break;
	      }
	      answer = new int[list.size()];
	      for(int i = 0; i < list.size(); i++) {
	    	  answer[i] = list.get(i);
	      }
      return answer;
  }
}