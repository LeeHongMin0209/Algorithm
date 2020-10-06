package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7453 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];
		int[] ab = new int[n*n];
		int[] cd = new int[n*n];
		long cnt = 0;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}
		int abid = 0;
		//a,b와 c,d 배열을 각각 합쳐준다 -> ab, cd
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ab[abid] = a[i] + b[j];
				cd[abid] = c[i] + d[j];
				abid++;
			}
		}
		//cd배열의 포인터
		int cdid = abid-1;
		//오름차순 정렬
		Arrays.sort(ab);
		Arrays.sort(cd);
		
		//i는 ab의 포인터, cdid는 cd의 포인터
		for(int i = 0; i < abid && cdid >= 0;) {
			int abSum = ab[i];
			int cdSum = cd[cdid];
			int abCnt = 0;
			int cdCnt = 0;
			int toSum = abSum + cdSum;
			if(toSum == 0) {
				//조건에 맞으면서 중복숫자의 갯수 파악
				while(i < abid && abSum == ab[i]) {
					i++;
					abCnt++;
				}
				//조건에 맞으면서 중복숫자의 갯수 파악
				while(cdid >= 0 && cdSum == cd[cdid]) {
					cdid--;
					cdCnt++;
				}
				//중복된 숫자끼리 곱해서 합이 0인 총 경우의 수를 구함. ex)-3이 3개, 3이 2개일 경우 총 6가지
				cnt += (long)abCnt * (long)cdCnt;
			} else if(toSum > 0) {
				//합이 0보다크면 cd 포인터 줄이기
				cdid--;
			} else {
				//합이 0보다 작으면 ab 포인터 늘리기
				i++;
			}
		}	
		System.out.println(cnt);
	}

}
