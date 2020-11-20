package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int minLen = Integer.MAX_VALUE;
		int left = 0, right = 0;
		int sum = 0;
		while(true) {
			if(sum >= m) {
				//end를 증가하면서 sum을 뺀다
				sum -= arr[left];
				
                //M 값 이상이되면 동일하면 len을 구하고
				int len = right - left;
				minLen = Math.min(len, minLen);
				left++;
			} else if(right == n) {
				break;
			} else {
				//start 로 배열을 증가하면서 sum을 증가
				sum += arr[right++];
			}
		}
		if(minLen == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(minLen);
	}

}
