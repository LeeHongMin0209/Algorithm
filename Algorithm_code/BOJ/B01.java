package BOJ;

public class B01 {
	static public String solution(int n, int[][] delivery) {
		String answer = "";
		int[] arr  = new int[n+1];
		for(int i = 0; i < delivery.length; i++) {
			int one = delivery[i][0];
			int two = delivery[i][1];
			int deli = delivery[i][2];
			if(deli == 1) {
				
				arr[one] = 1;
				arr[two] = 1;
			}
		}
		for(int i = 0; i < delivery.length; i++) {
			int one = delivery[i][0];
			int two = delivery[i][1];
			int deli = delivery[i][2];
			if(deli == 0) {
				if(arr[one] == 1 && arr[two] == 0) {
					arr[two] = 2;
				} else if(arr[two]  == 1 && arr[one] == 0) {
					arr[one] = 2;
				}
			}
		}
		for(int i = 1; i <= n; i++) {
			if(arr[i] == 1) answer += "O";
			else if(arr[i] == 2) answer += "X";
			else answer +="?";
		}
		return answer;
	}
	public static void main(String[] args) {
		int n = 7;
		int[][] delivery = 	{{5,6,0},{1,3,1},{1,5,0},{7,6,0},{3,7,1},{2,5,0}};
		int[][] deliver2 = {{1,3,1},{3,5,0},{5,4,0},{2,5,0}};
		String ans = solution(n, delivery);
		System.out.println(ans);
	}
}
