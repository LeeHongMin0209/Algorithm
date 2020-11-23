package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ3190 {
	static class dir{
		int time;
		String d;
		public dir(int time, String d) {
			this.time = time;
			this.d = d;
		}
	}
	static class dot{
		int x;
		int y;
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int n,k,l;
	static int[][] map;
	static ArrayList<dot> snake = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		}
		l = Integer.parseInt(br.readLine());
		ArrayList<dir> list = new ArrayList<>();
		for(int i = 0; i < l ; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new dir(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		snake.add(new dot(1, 1));
		int dirIdx = 0;
		int ans = 0;
		int Sdir = 0;
		while(true) {
			if(dirIdx < list.size()) {
				if(ans == list.get(dirIdx).time) {
					if(list.get(dirIdx).d.equals("D")) {
						Sdir += 1;
						Sdir %= 4;
					} else if(list.get(dirIdx).d.equals("L")) {
						Sdir += 3;
						Sdir %= 4;				
					}
					dirIdx++;
				}
			}
			int headX = snake.get(0).x;
			int headY = snake.get(0).y;
			if(Sdir == 0) {
				if(isRange(headX, headY+1) && isContain(headX, headY+1)) {
					if(map[headX][headY+1] == 1) {
						snake.add(0,new dot(headX, headY+1));
						map[headX][headY+1] = 0;
					} else {
						for(int i = snake.size()-1; i > 0; i--) {
							snake.set(i, snake.get(i-1));
						}
						snake.set(0,new dot(headX, headY+1));
					}
				} else {
					ans++;
					break;
				}
			} else if(Sdir == 1) {
				if(isRange(headX+1, headY) && isContain(headX+1, headY)) {
					if(map[headX+1][headY] == 1) {
						snake.add(0,new dot(headX+1, headY));
						map[headX+1][headY] = 0;
					} else {
						for(int i = snake.size()-1; i > 0; i--) {
							snake.set(i, snake.get(i-1));
						}
						snake.set(0,new dot(headX+1, headY));
					}
				} else {
					ans++;
					break;
				}
			} else if(Sdir == 2) {
				if(isRange(headX, headY-1) && isContain(headX, headY-1)) {
					if(map[headX][headY-1] == 1) {
						snake.add(0,new dot(headX, headY-1));
						map[headX][headY-1] = 0;
					} else {
						for(int i = snake.size()-1; i > 0; i--) {
							snake.set(i, snake.get(i-1));
						}
						snake.set(0,new dot(headX, headY-1));
					}
				} else {
					ans++;
					break;
				}
			} else if(Sdir == 3) {
				if(isRange(headX-1, headY) && isContain(headX-1, headY)) {
					if(map[headX-1][headY] == 1) {
						snake.add(0,new dot(headX-1, headY));
						map[headX-1][headY] = 0;
					} else {
						for(int i = snake.size()-1; i > 0; i--) {
							snake.set(i, snake.get(i-1));
						}
						snake.set(0,new dot(headX-1, headY));
					}
				} else {
					ans++;
					break;
				}
			}
			ans++;
		}
//		System.out.println(snake.get(0).x +"  " + snake.get(0).y);
//		System.out.println(snake.size());
		System.out.println(ans);
	}
	static private boolean isRange(int x, int y) {
		if(x < 1 || x > n || y < 1 || y > n) return false;
		return true;
	}
	static private boolean isContain(int x, int y) {
		for(dot s : snake) {
			if(s.x == x && s.y == y) return false;
		}
		return true;
	}
}
