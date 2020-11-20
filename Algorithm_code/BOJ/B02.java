package BOJ;

public class B02 {
	
	static public String solution(String encrypted_text, String key, int rotation) {
		String answer = "";
		int len = encrypted_text.length();
		int ro = Math.abs(rotation);
		if(rotation < 0) {
			for(int i = 0; i < ro; i++) {
				String str = "";
				str += encrypted_text.charAt(encrypted_text.length()-1);
				for(int j = 0; j < encrypted_text.length() - 1; j++) {
					str += encrypted_text.charAt(j);
				}
				encrypted_text = str;
			}
		} else {
			for(int i = 0; i < ro; i++) {
				String str = "";
				for(int j = 1; j < encrypted_text.length(); j++) {
					str += encrypted_text.charAt(j);
				}
				str += encrypted_text.charAt(0);
				encrypted_text = str;
			}
		}
		for(int i = 0; i < key.length(); i++) {
			char target = encrypted_text.charAt(i);
			int x = target - '0';
			int targetNum = x - 48;
			char ch = key.charAt(i);
			int y = ch - '0';
			int num = y - 48;
			int result = targetNum - num;
			if(result <= 0) result += 26;
			result += 48;
			char change = (char) (result +'0');
			String newStr = "";
			for(int j = 0; j < encrypted_text.length(); j++) {
				if(i != j) newStr += encrypted_text.charAt(j);
				else newStr += change;
			}
			encrypted_text = newStr;
		}
		answer = encrypted_text;
		return answer;
	}
	public static void main(String[] args) {
		String encrypted_text = "qyyigoptvfb";
		String key = "abcdefghijk";
		int rotation = 3;
		String ans = solution(encrypted_text, key, rotation);
		System.out.println(ans);
	}
}
