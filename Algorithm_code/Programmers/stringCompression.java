package Programmers;

public class stringCompression {
	static public int solution(String s) {
		int answer = Integer.MAX_VALUE;
		int n = s.length()/2;
		int tmp = 0;
		for(int i = 1; i <= n; i++) {
			tmp = compression(i, s);
			answer = Math.min(tmp, answer);
		}	
		if(answer == Integer.MAX_VALUE) answer = 1;
		return answer;
	}
	static int compression(int i, String s) {
		String com = "";
		char[] arr = s.toCharArray();
		int trans = 1;
		int length = arr.length;
		int na = length % i;
		length -= na;
		for(int j = 0; j < length-i; j+=i) {
			String s1 = "";
			String s2 = "";
			for(int k = j; k <= j+i-1; k++) {
				s1 += String.valueOf(arr[k]);
				s2 += String.valueOf(arr[k+i]);
			}
			if(s1.equals(s2)) {
				trans++;		
				if(j == length-i-i) {
					com += String.valueOf(trans);
					com += String.valueOf(s1);
				} 
			}
			else {
				if(j == length-i-i) {
						if(trans == 1) {
							com += String.valueOf(s1);
							com += String.valueOf(s2);														
						} else {
							com += String.valueOf(trans);
							com += String.valueOf(s1);
							com += String.valueOf(s2);
						}
				} else {
					if(trans == 1) {
						com += String.valueOf(s1);
					} else {
						com += String.valueOf(trans);
						com += String.valueOf(s1);
						trans = 1;
					}
				}
			}			
		}
		for(int j = length; j < arr.length; j++) {
			com += String.valueOf(arr[j]);
		}
		return com.length();
	}
	public static void main(String[] args) {
		String s = "a";
		int ans = solution(s);
		System.out.println("ans : "+ ans);
	}
}
