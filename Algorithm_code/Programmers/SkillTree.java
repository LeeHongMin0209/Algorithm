package Programmers;

public class SkillTree {
	 public int solution(String skill, String[] skill_trees) {
		 int answer = 0;
		 for(int i = 0; i < skill_trees.length; i++) {
			 boolean check = true;
			 int idx = 0;
			 for(char curCh : skill_trees[i].toCharArray()) {
				 int temp = skill.indexOf(curCh);
				 
				 if(temp == -1) continue;	        		
				 else if(temp == idx) {
					 idx++;
				 }else {
					 check = false;
					 break;
				 }	        		
			 }
			 if(check) answer++;
		 }
		 return answer;
	 }
}



