package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14499 {
	static int n,m,x,y,k,dir,one,two,three,four,five,six;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0 ; i < 6; i++) {
			list.add(0);
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < k; i++) {
			dir = Integer.parseInt(st.nextToken());
			if(dir == 1) {
				if(isRable(x, y+1)) {
					y++;
					one = list.get(0);
					three = list.get(2);
					four = list.get(3);
					six = list.get(5);
					if(map[x][y] == 0) {
						list.set(2, one);
						list.set(0, four);
						list.set(3, six);
						list.set(5, three);
						map[x][y] = list.get(5);
					} else {
						list.set(2, one);
						list.set(5, map[x][y]);
						list.set(0, four);
						list.set(3, six);
						map[x][y] = 0;
					}
					System.out.println(list.get(0));
				}
				
				
			} else if(dir == 2) {
				if(isRable(x, y-1)) {
					y--;
					one = list.get(0);
					three = list.get(2);
					six = list.get(5);
					four = list.get(3);
					if(map[x][y] == 0) {
						list.set(3, one);
						list.set(2, six);
						list.set(0, three);
						list.set(5, four);
						map[x][y] = list.get(5);
					} else {
						list.set(3, one);
						list.set(5, map[x][y]);
						list.set(2, six);
						list.set(0, three);		
						map[x][y] = 0;
					}
					System.out.println(list.get(0));
				}
			} else if(dir == 3) {
				if(isRable(x-1, y)) {
					x--;
					one = list.get(0);
					two = list.get(1);
					six = list.get(5);
					five = list.get(4);
					if(map[x][y] == 0) {
						list.set(4, one);
						list.set(5, five);
						list.set(1, six);
						list.set(0, two);
						map[x][y] = list.get(5);
					} else {
						list.set(4, one);
						list.set(5, map[x][y]);
						list.set(1, six);
						list.set(0, two);
						map[x][y] = 0;
					}
					System.out.println(list.get(0));
				}
			} else if(dir == 4) {
				if(isRable(x+1, y)) {
					x++;
					one = list.get(0);
					two = list.get(1);
					six = list.get(5);
					five = list.get(4);
					if(map[x][y] == 0) {
						list.set(1, one);
						list.set(5, two);
						list.set(4, six);
						list.set(0, five);	
						map[x][y] = list.get(5);
					} else {
						list.set(1, one);
						list.set(5, map[x][y]);
						list.set(4, six);
						list.set(0, five);	
						map[x][y] = 0;
					}
					System.out.println(list.get(0));
				}
			}
		}
	}
	static boolean isRable(int x,  int y) {
		if(x >= 0 && x < n && y >=0 && y < m) return true;
		return false;
	}
}
