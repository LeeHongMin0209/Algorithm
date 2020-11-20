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
				//end�� �����ϸ鼭 sum�� ����
				sum -= arr[left];
				
                //M �� �̻��̵Ǹ� �����ϸ� len�� ���ϰ�
				int len = right - left;
				minLen = Math.min(len, minLen);
				left++;
			} else if(right == n) {
				break;
			} else {
				//start �� �迭�� �����ϸ鼭 sum�� ����
				sum += arr[right++];
			}
		}
		if(minLen == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(minLen);
	}

}
