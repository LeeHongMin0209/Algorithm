package LeetCode;

public class Leet1310 {
	static public int[] xorQueries(int[] arr, int[][] queries) {
		int[] ans = new int[queries.length];
		
		for(int i = 0; i < ans.length; i++) {
			if(queries[i][0] == queries[i][1]) ans[i] = arr[queries[i][0]];
			else {
				int temp = 0;
				for(int j = queries[i][0]; j <= queries[i][1]; j++) {
					temp = temp ^ arr[j];
				}				
				ans[i] = temp;
			}
		}
		
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {1,3,4,8};
		int[][] qu = {{0,1},{1,2},{0,3},{3,3}};
		int[] ans = xorQueries(arr, qu);
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
