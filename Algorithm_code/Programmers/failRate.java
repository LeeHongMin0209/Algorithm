package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class failRate {
	static class fail {
		double failRate;
		int index;
		public fail(double failRate, int index)  {
			this.failRate = failRate;
			this.index = index;
		}	
	}
	static public int[] solution(int N, int[] stages) {
        int[] answer = {};
        answer = new int[N];
        int[] cur = new int[N+1];
        for(int i = 0; i < stages.length; i++) {
        	if(stages[i] != N+1) cur[stages[i]]++;
        }

        int user = stages.length;
        fail[] fails = new fail[N+1];
        fails[0] = new fail(-1, Integer.MAX_VALUE);
        
        for(int i = 1; i < cur.length; i++ ) {
        	if(user == 0) {
        		fails[i] = new fail(0, i);
        	} else {
        		fails[i] = new fail((double)cur[i]/user, i);
        		user -= cur[i];
        	}
        }     
  
        Arrays.sort(fails, new Comparator<fail>() {
        	public int compare(fail o1, fail o2) {
                if(o1.failRate != o2.failRate) {
                    return -Double.compare(o1.failRate, o2.failRate);
                }
                return o1.index - o2.index;
            }
        });
        
        for(int i = 0; i < N; i++) {
        	answer[i] = fails[i].index;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		int n = 5;
		int[] stages = {2,1,2,6,2,4,3,3};
		int[] answer = solution(n, stages);
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
