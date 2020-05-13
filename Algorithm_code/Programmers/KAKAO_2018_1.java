package Programmers;

import java.util.ArrayList;

public class KAKAO_2018_1 {
	public int solution(String str1, String str2) {
	      int answer = 0;
	       ArrayList<String> multiSet1 = new ArrayList<>();
		   ArrayList<String> multiSet2 = new ArrayList<>();
		   ArrayList<String> union = new ArrayList<>();
		   ArrayList<String> intersection = new ArrayList<>();
		      
		      str1 = str1.toLowerCase();
		      str2 = str2.toLowerCase();
		      
		      for(int i = 0 ; i < str1.length() - 1 ; ++i){
		          char first = str1.charAt(i);
		          char second = str1.charAt(i + 1);
		          
		          if(first >= 'a' && first <= 'z' &&
		             second >= 'a' && second <= 'z'){
		              multiSet1.add(first + "" + second);
		          }
		      }
		      
		      for(int i = 0 ; i < str2.length() - 1 ; ++i){
		          char first = str2.charAt(i);
		          char second = str2.charAt(i + 1);
		          
		          if(first >= 'a' && first <= 'z' &&
		             second >= 'a' && second <= 'z'){
		              multiSet2.add(first + "" + second);
		          }
		      }
		      Collections.sort(multiSet1);
		      Collections.sort(multiSet2);
		      
		      for(String s : multiSet1) {
		    	  if(multiSet2.remove(s)) {
		    		  intersection.add(s);
		    	  }
		    	  union.add(s);
		      }
		      for(String s : multiSet2) {
		    	  union.add(s);
		      }
		      double jakad = 0;
		      if(union.size() == 0 && intersection.size() == 0) {
		    	  jakad = 1;
		      }
		      else {
		    	 jakad = (double) intersection.size() / union.size();
		      }
		     answer = (int ) Math.floor(jakad*65536);
	      return answer;
	  }
}
