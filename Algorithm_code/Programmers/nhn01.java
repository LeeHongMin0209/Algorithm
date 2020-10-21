package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class nhn01 {
	static class dot{
		int x;
		int y;
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static boolean[][] visited;
	static ArrayList<Integer> ansList = new ArrayList<>();
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) {
		 InputData inputData = processStdin();

		 solution(inputData.sizeOfMatrix, inputData.matrix);
	}
	
	private static void solution(int sizeOfMatrix, int[][] matrix) {
		visited = new boolean[sizeOfMatrix][sizeOfMatrix];
		
		for(int i = 0; i < sizeOfMatrix; i++) {
			for(int j = 0; j < sizeOfMatrix; j++) {
				if(matrix[i][j] == 1 && !visited[i][j]) {
					bfs(i, j, sizeOfMatrix, matrix);
				}
			}
		}
		System.out.println(ansList.size());
		Collections.sort(ansList);
		for(int x : ansList) System.out.print(x + " ");
	}
	
	private static class InputData {
		int sizeOfMatrix;
		int[][] matrix;
	}
	
	private static InputData processStdin() {
		InputData inputData = new InputData();
		
		try (Scanner scanner = new Scanner(System.in)) {
			inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
			
			inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
			for (int i = 0; i < inputData.sizeOfMatrix; i++) {
				String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
				for (int j = 0; j < inputData.sizeOfMatrix; j++) {
					inputData.matrix[i][j] = Integer.parseInt(buf[j]);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		
		return inputData;
	}
	static void bfs(int x, int y, int n, int[][] map) {
		int cnt = 0;
		Queue<dot> qu = new LinkedList<>();
		qu.add(new dot(x, y));
		visited[x][y] = true;
		cnt++;
		
		while(!qu.isEmpty()) {
			dot d = qu.poll();
			
			for(int i = 0; i < 4; i++) {
				int xx = d.x + dx[i];
				int yy = d.y + dy[i];
				
				if(xx < 0 || xx >= n || yy < 0 || yy >= n) continue;
				
				if(!visited[xx][yy] && map[xx][yy] == 1) {
					qu.add(new dot(xx, yy));
					visited[xx][yy] = true;
					cnt++;
				}
			}
		}
		ansList.add(cnt);
	}
}
