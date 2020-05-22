package Programmers;

public class Square {
    static public long solution(int w, int h) {
        long answer = 0;
          
        for(int i = 0; i < w; i++) 
            answer += (Long.valueOf(h) * i) / Long.valueOf(w);
        
        return answer;
    }
    public static void main(String[] args) {
		int w = 4;
		int h = 2;
		long ans = solution(w, h);
		System.out.println(ans);
	}
}
