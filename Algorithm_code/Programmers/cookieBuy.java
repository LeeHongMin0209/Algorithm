package Programmers;

public class cookieBuy {
	public static void main(String[] args) {
		int[] cookie = {1,1,2,3};
		int ans = solution(cookie);
		System.out.println(ans);
	}
	static public int solution(int[] cookie) {
		int answer = 0;
		for(int i = 0; i < cookie.length - 1; i++) {
			int left = i;
			int leftSum = cookie[i];
			
			int right = i + 1;
			int rightSum = cookie[i+1];
			while(true) {
				if(leftSum == rightSum && answer < leftSum) {
					answer = leftSum;
				} else if(leftSum <= rightSum && left != 0) {
					left--;
					leftSum += cookie[left];
				} else if(rightSum <= leftSum && right != cookie.length-1) {
					right++;
					rightSum += cookie[right];
				} else if(left == 0 || right == cookie.length-1){
					break;
				}
			}
		}
		return answer;
	}
}
