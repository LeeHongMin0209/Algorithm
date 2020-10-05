package Programmers;

public class decimalMaking {
	static boolean[] visited;
	static int[] arr;
	static int ans;
	static public int solution(int[] nums) {
        int answer = -1;
        int len = nums.length;
        visited = new boolean[nums.length];
        arr = new int[3];
        back(0, len, nums, 0);
        answer = ans;
        return answer;
    }
	static void back(int k, int len, int[] nums, int start) {
		if(k == 3) {
			int num = 0;
			for(int i = 0; i < 3; i++) {
				num += arr[i];
			}
			if(check(num)) ans++;
			return;
		}
		for(int i = start; i < len; i++) {
        	if(!visited[i]) {
        		arr[k] = nums[i];
        		visited[i] = true;
        		back(k+1, len, nums, i+1);
        		visited[i] = false;
        	}
        }
	}
	static boolean check(int num) {
		int cnt = 0;
		for(int i = 1; i <= num; i++) {
			if(num % i == 0) cnt++;
		}
		if(cnt == 2) return true;
		return false;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,7,6,4};
		int ans = solution(nums);
		System.out.println(ans);
	}
}
