package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Trans {
	 public int solution(String begin, String target, String[] words) {
	        int answer = 0;
	         List<String> wordlist = new ArrayList<>();
			 for(int i = 0; i < words.length; i++) {
				 wordlist.add(words[i]);
			 }
			 answer = recosion(begin,target,wordlist,0);
	        return answer;
	    }
	     public static int recosion(String begin, String target, List<String> wordlist, int stack) {
			 char[] beginlist = begin.toCharArray();
			 char[] targetlist = target.toCharArray();
			 int check = beginlist.length - 1;
			 for(int i = 0; i<wordlist.size(); i++) {
				 int count = 0;
				 int targetcount = 0;
				 char[] compare = wordlist.get(i).toCharArray();
				 for(int j = 0; j < beginlist.length; j++) {
					 if(beginlist[j]==compare[j]) {
						 count++;
					 }
					 if(beginlist[j] == targetlist[j]) {
						 targetcount++;
					 }
				 }
				 if(targetcount == check+1) {
					 stack++;
					 return stack;
				 }
				 if(count==check) {
					 begin = wordlist.get(i);
					 stack ++;
					 wordlist.remove(i);
					 return recosion(begin, target, wordlist, stack);
				 }
			 }
			 return 0;
	     }
}
