package BOJ;

import java.util.ArrayList;
import java.util.HashSet;

public class english {
	static public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		int num = 0;
		int turn = 1;
		boolean check = false;
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i < words.length; i++) {
			String word = words[i];
			if(i != 0) {
				if(word.charAt(0) != words[i-1].charAt(words[i-1].length()-1)) {
					check = true;
					num++;
					if(num > n) {
						num = 1;
						turn++;
					}
					break;
				}
			}
			if(list.contains(word)) {
				check = true;
				num++;
				if(num > n) {
					System.out.println(word);
					num = 1;
					turn++;
				}
				break;
			}
			list.add(word);
			num++;
			if(num > n) {
				num = 1;
				turn++;
			}
		}
		if(check) {
			answer[0] = num;
			answer[1] = turn;
		}
		return answer;
	}
	public static void main(String[] args) {
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int n = 3;
		int ans[] = solution(n, words);
		System.out.println(ans[0] + " " + ans[1]);
	}
}
