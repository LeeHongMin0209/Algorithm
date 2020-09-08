package Programmers;

public class failRate {
	static class rate implements Comparable<rate>{
		int index;
		int failRate;
		public rate(int index, int failRate) {
			this.index = index;
			this.failRate = failRate;
		}
		@Override
		public int compareTo(rate r) {
			return this.failRate <= r.failRate ? 1 : -1;
		}
		
	}
	public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        return answer;
    }
}
