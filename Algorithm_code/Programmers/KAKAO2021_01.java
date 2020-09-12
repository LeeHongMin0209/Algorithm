package Programmers;

public class KAKAO2021_01 {
	static public String solution(String new_id) {
		String answer = "";
		String trans = "";
		trans = one(new_id);
		trans = two(trans);
		trans = three(trans);
		trans = four(trans);
		trans = five(trans);
		trans = six(trans);
		trans = four(trans);
		trans = seven(trans);
		answer = trans;
		return answer;
	}
	static String one(String new_id) {
		char[] arr = new_id.toCharArray();
		for(int i = 0; i < new_id.length(); i++) {
			int index = (int)arr[i];
			
			if(index >= 65 && index <= 90) {
				arr[i] = (char) (arr[i] + 32);		
			}
		}
		String s = "";
		for(int i = 0; i < arr.length; i++) {
			s += arr[i];
		}
		return s;
	}
	static String two(String new_id) {
		char[] arr = new_id.toCharArray();
		char[] compare = {'0','1','2','3','4','5','6','7','8','9','-','_','.'};
		String s = "";
		for(int i = 0; i < new_id.length(); i++) {
			int index = (int)arr[i];
			if(index >= 97 && index <= 122) {
				s += arr[i];
				continue;
			}
			for(int j = 0; j < compare.length; j++) {
				if(arr[i] == compare[j]) {
					s += arr[i];
				}
			}
		}
		return s;
	}
	static String three(String new_id) {
		char[] arr = new_id.toCharArray();
		int cnt = 0;
		String s = "";
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == '.' && cnt==0) {
				s += arr[i];
				cnt++;
			} else if(arr[i] == '.' && cnt != 0) {
				continue;
			} else if(arr[i] != '.') {
				s += arr[i];
				cnt = 0;
			}
		}	
		return s;
	}
	static String four(String new_id) {
		char[] arr = new_id.toCharArray();
		String s = "";
		for(int i = 0; i < arr.length; i++) {
			if(i == 0 && arr[i] == '.') continue;
			if(i == arr.length-1 && arr[arr.length-1] =='.') continue;
			s += arr[i];
		}
		return s;
	}
	static String five(String new_id) {
		String s = new_id;
		if(new_id.length() == 0) s = "a";
		return s;
	}
	static String six(String new_id) {
		char[] arr = new_id.toCharArray();
		String s = new_id;
		if(new_id.length() >= 16) {
			s = "";
			for(int i =0; i < 15; i++) s += arr[i];			
		}
		return s;
	}
	static String seven(String new_id) {
		char[] arr = new_id.toCharArray();
		String s = new_id;
		if(arr.length <=2) {
			char tmp = arr[arr.length-1];
			while(true) {
				s += tmp;
				if(s.length() ==3) break;
			}
		}
		return s;
	}
	public static void main(String[] args) {
		String s = 	"=.=";
		String asd = solution(s);
		System.out.println(asd);
		char qwe = 'b';
		System.out.println((int)qwe);
	}
}
