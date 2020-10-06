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
		//a,b�� c,d �迭�� ���� �����ش� -> ab, cd
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ab[abid] = a[i] + b[j];
				cd[abid] = c[i] + d[j];
				abid++;
			}
		}
		//cd�迭�� ������
		int cdid = abid-1;
		//�������� ����
		Arrays.sort(ab);
		Arrays.sort(cd);
		
		//i�� ab�� ������, cdid�� cd�� ������
		for(int i = 0; i < abid && cdid >= 0;) {
			int abSum = ab[i];
			int cdSum = cd[cdid];
			int abCnt = 0;
			int cdCnt = 0;
			int toSum = abSum + cdSum;
			if(toSum == 0) {
				//���ǿ� �����鼭 �ߺ������� ���� �ľ�
				while(i < abid && abSum == ab[i]) {
					i++;
					abCnt++;
				}
				//���ǿ� �����鼭 �ߺ������� ���� �ľ�
				while(cdid >= 0 && cdSum == cd[cdid]) {
					cdid--;
					cdCnt++;
				}
				//�ߺ��� ���ڳ��� ���ؼ� ���� 0�� �� ����� ���� ����. ex)-3�� 3��, 3�� 2���� ��� �� 6����
				cnt += (long)abCnt * (long)cdCnt;
			} else if(toSum > 0) {
				//���� 0����ũ�� cd ������ ���̱�
				cdid--;
			} else {
				//���� 0���� ������ ab ������ �ø���
				i++;
			}
		}	
		System.out.println(cnt);
	}

}
