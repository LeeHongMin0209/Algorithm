package Programmers;

public class Target {
	static int cnt;
    static public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers,0,0,target);
        answer = cnt;
        return answer;
    }
    static void dfs(int[] number, int idx, int sum,int target) {
    	if(idx == number.length) {
    		if(sum==target) {
    			cnt++;
    			return;
    		}
    		return;
    	}
    	dfs(number, idx+1, sum+number[idx],target);
    	dfs(number, idx+1, sum-number[idx],target );
    }
    public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		int ans = solution(numbers, target);
		System.out.println(ans);
	}
}
