package BOJ;

import java.util.LinkedList;
import java.util.Queue;

public class B03 {
	static class dot{
		int x;
		int y;
		public dot(int x ,int y) {
			this.x = x;
			this.y = y;
		}
	}
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int len = 0;
	static public int[] solution(int[][] v){
		int[] answer = new int[3];
		len = v.length;
		visited = new boolean[v.length][v.length];
		for(int i = 0; i < v.length; i++) {
			for(int j = 0; j < v.length; j++) {
				dot d = new dot(i, j);
				if(!visited[i][j]) {
					bfs(i, j, v[i][j], answer, v);
				}
			}
		}
		return answer;
	}
	static void bfs(int x, int y, int z, int[] ans, int[][] v) {
		Queue<dot> qu = new LinkedList<>();
		dot d = new dot(x, y);
		qu.add(d);
		visited[x][y] = true;
		while(!qu.isEmpty()) {
			dot d1 = qu.poll();
			for(int i = 0; i < 4; i++) {
				int xx = d1.x + dx[i];
				int yy = d1.y + dy[i];
				if(xx < 0 || xx >= len || yy < 0 || yy>= len) continue;
				
				if(!visited[xx][yy] && v[xx][yy] == z) {
					qu.add(new dot(xx, yy));
					visited[xx][yy] = true;
				}
			}
		}
		ans[z]++;
	}

}
