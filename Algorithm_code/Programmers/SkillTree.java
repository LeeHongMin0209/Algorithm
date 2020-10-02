package Programmers;

public class SkillTree {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		for(int i = 0; i < skill_trees.length; i++) {
			boolean check = check_skill(skill, skill_trees[i]);
			if(check) answer++;
		}
		return answer;
	} 
	static boolean check_skill(String skill, String skill_tree) {
		char[] arr1 = skill.toCharArray();
		char[] arr2 = skill_tree.toCharArray();
		int idx = 0;
		for(int i = 0; i < arr2.length; i++) {
			char ch = arr2[i];
			for(int j = 0; j < arr1.length; j++) {
				if(arr1[j] == arr2[i] && idx != j) return false;
				else if(arr1[j] == arr2[i] && idx == j) idx++;  
			}
		}
		return true;
	}
}



