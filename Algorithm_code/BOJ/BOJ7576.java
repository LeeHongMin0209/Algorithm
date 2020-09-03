package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
	static class tomato{
		int x;
		int y;
		public tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] box;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int day, n, m, ans, cnt;
	static Queue<tomato> qu = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		box = new int[m][n];
		visited = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j < n; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) qu.add(new tomato(i, j));
				if(box[i][j] == 0) cnt++;
			}
		}
		if(cnt == 0) System.out.println(0);
		else {
			bfs();
			cnt = 0;
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(box[i][j] == 0) cnt++;
				}
			}
			if(cnt == 0) System.out.println(ans-1);
			else System.out.println(-1);
		}
		
	}
	
	static private void bfs() {
		while(!qu.isEmpty()) {
			int size = qu.size();
			for(int i = 0; i < size; i++) {
				tomato t = qu.poll();
				for(int j = 0; j < 4; j++) {
					int x1 = t.x + dx[j];
					int y1 = t.y + dy[j];
					
					if(x1 < 0 || x1 >= m || y1 < 0 || y1 >= n) continue;
					if(box[x1][y1] == 0 && !visited[x1][y1]) {
						qu.add(new tomato(x1, y1));
						visited[x1][y1] = true;
						box[x1][y1] = 1;
					}
				}
			}
			ans++;
		}
	}
}
