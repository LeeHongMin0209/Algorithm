package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class BOJ15686 {
	static class dot{
		int x;
		int y;
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n,m;
	static int ans = Integer.MAX_VALUE;
	static int[][] map = new int[52][52];
	static Vector<dot> house = new Vector<>();
	static Vector<dot> chicken = new Vector<>();
	static int[] chickenLength;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) house.add(new dot(i, j));
				else if(map[i][j] == 2) chicken.add(new dot(i, j));
			}
		}
		
		
		n = chicken.size();
		boolean[] visited = new boolean[n];
		dot[] arr = new dot[n];
		for(int i = 0; i < n; i++) {
   		 arr[i] = new dot(0, 0);
   	 }
		for(int i = 0; i < n; i++) {
			arr[i].x = chicken.get(i).x;
			arr[i].y = chicken.get(i).y;
		}
		chickenLength = new int[house.size()];
		for(int j =0 ; j < house.size(); j++) {
			chickenLength[j] = Integer.MAX_VALUE;				
		}
		for(int i = 1; i <= m; i++) {
			combination(arr, visited, 0, n, i,i);
		}
		System.out.println(ans);
	}
	static int minLenth(dot chicken, dot house) {
		int chickenX = chicken.x;
		int chickenY = chicken.y;
		int houseX = house.x;
		int houseY = house.y;
		int x = Math.abs(chickenX - houseX);
		int y = Math.abs(chickenY - houseY);
		return x+y;
	}
	//조합 코드
	static void combination(dot[] arr, boolean[] visited, int start, int n, int r, int check) {
		if (r == 0) {
			for(int j =0 ; j < house.size(); j++) {
				chickenLength[j] = Integer.MAX_VALUE;				
			}
        	int cnt = 0;
        	 for (int i = 0; i < n; i++) {
                 if (visited[i]) cnt++;
             }
        	 dot[] arr2 = new dot[cnt];
        	 for(int i = 0; i < cnt; i++) {
        		 arr2[i] = new dot(0, 0);
        	 }
        	 int c = 0;
        	 for(int i = 0; i < n; i++) {
        		 if(visited[i]) {
        			 arr2[c].x = arr[i].x;
        			 arr2[c].y = arr[i].y;
        			 c++;
        		 }
        	 }
        	int size = arr2.length;
        	if(check == 1) {
        		for(int j = 0; j < size; j++) {
        			for(int k = 0; k < house.size(); k++) {
        				chickenLength[k] = minLenth(arr2[j], house.get(k));
        			}
        		}
        		int tmp = 0;
        		for(int i = 0; i < chickenLength.length; i++) {
        			tmp += chickenLength[i];
        		}
        		ans = Math.min(ans, tmp);
        	} else {
        		for(int j = 0; j < size; j++) {
        			for(int k = 0; k < house.size(); k++) {
        				chickenLength[k] = Math.min(chickenLength[k], minLenth(arr2[j], house.get(k)));
        			}
        		}
        		int tmp = 0;
        		for(int i = 0; i < chickenLength.length; i++) {
        			tmp += chickenLength[i];
        		}
        		ans = Math.min(ans, tmp);
        	}
        	return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1,check);
            visited[i] = false;
        }
    }
}
