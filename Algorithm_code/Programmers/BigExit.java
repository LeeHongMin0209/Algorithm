package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BigExit {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			int[] colorArr = new int[50];
			int[] CarArr = new int[1000];
			int[] tempArr = new int[50];
			int totalCar = 0;
			int tempCar = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				colorArr[j] += Integer.parseInt(st.nextToken());
				tempArr[j] += colorArr[j];
				totalCar += colorArr[j];
			}
			tempCar = totalCar;
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < n; j++) {
				CarArr[j] = Integer.parseInt(st.nextToken());
			}
			
			boolean check = false;
			int startCar = 0;
			loop : for(int j = 0; j < n; j++) {
				for(int k = j; k < n; k++) {
					int index = CarArr[k] - 1;
					if(tempArr[index] > 0) {
						tempArr[index]--;
						tempCar--;
						if(tempCar == 0) {
							check = true;
							startCar = k - totalCar + 2;
							break loop;
						}
					}
					else {
						for(int z = 0; z < m; z++) {
							tempArr[z] = colorArr[z];
						}
						tempCar = totalCar;
						break;
					}
				}
			}
			if(check) {
				System.out.print("#"+ (i+1)+" ");
				System.out.println(startCar);
			}
			else {
				System.out.println("#"+ (i+1) + " 0");
			}
		}
	}
}

