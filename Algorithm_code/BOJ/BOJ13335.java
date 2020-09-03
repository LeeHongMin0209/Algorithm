package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13335 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Queue<Integer> bridge = new LinkedList<Integer>(); 
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] truck = new int[n];
		for(int i = 0; i < n; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}
		
		int totalWeigth = 0;
		int time = 0;
		for(int i = 0; i < n; i++) {
			while(true) {
				if(bridge.isEmpty()) {
					bridge.add(truck[i]);
					totalWeigth += truck[i];
					time++;
					break;
				} else if(bridge.size() == w) {
					totalWeigth -= bridge.poll();
				} else {
					if(totalWeigth + truck[i] > l) {
						bridge.add(0);
						time++;
					} else {
						bridge.add(truck[i]);
						totalWeigth += truck[i];
						time++;
						break;
					}
				}
			}
		}
		System.out.println(time + w);
	}
}