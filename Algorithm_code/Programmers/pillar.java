package Programmers;

import java.util.ArrayList;

public class pillar {
	static final int PILLAR = 0;
	static final int BEAM = 1;
	static final int DESTRUCT = 0;
	static final int CONSTRUCT = 1;
	
	static boolean[][] pillars, beams;
	static public int[][] solution(int n, int[][] build_frame) {
		int structureCount = 0;
		
		pillars = new boolean[n+3][n+3];
		beams = new boolean[n+3][n+3];
		
		for(int[] frame : build_frame) {
			int x = frame[0] + 1;
			int y = frame[1] + 1;
			int structureType = frame[2];
			int commandType = frame[3];
			
			if(commandType == CONSTRUCT) {
				if(structureType == PILLAR && canConstructPillar(x,y)) {
					pillars[x][y] = true;
					structureCount++;
				}
				if(structureType == BEAM && canConstructBeam(x,y)){
					beams[x][y] = true;
					structureCount++;
				}
			} else if(commandType == DESTRUCT) {
				if(structureType == PILLAR) {
					pillars[x][y] = false;
				} else if(structureType == BEAM) {
					beams[x][y] = false;
				}
				if(canDestruct(x, y, structureType, n)) {
					structureCount--;
					continue;
				}
				if(structureType == PILLAR) {
					pillars[x][y] = true;
				} else if(structureType == BEAM) {
					beams[x][y] = true;
				}
			}	
		}
		int index = 0;
		int[][] answer = new int[structureCount][3];
		
		for(int i = 1; i <= n + 1; i++) {
			for(int j = 1; j <= n + 1; j++) {
				if(pillars[i][j]) {
					answer[index] = new int[] {i-1,j-1,PILLAR};
					index++;
				}
				if(beams[i][j]) {
					answer[index] = new int[] {i-1,j-1,BEAM};
					index++;
				}
			}
		}
		return answer;
	}
	static boolean canConstructPillar(int x, int y) {
		return y == 1 || pillars[x][y - 1] || beams[x][y] || beams[x - 1][y];
	}
	static boolean canConstructBeam(int x, int y) {
		 return pillars[x][y - 1] || pillars[x + 1][y - 1] || (beams[x - 1][y] && beams[x + 1][y]);
	}
	static boolean canDestruct(int x, int y, int structureType, int n) {
		 for(int i = 1 ; i <= n + 1 ; i++){
	            for(int j = 1 ; j <= n + 1 ; j++){
	                if(pillars[i][j] && !canConstructPillar(i, j)){
	                    return false;
	                }
	                if(beams[i][j] && !canConstructBeam(i, j)){
	                    return false;
	                }
	            }
	        }
		return true;
	}
	public static void main(String[] args) {
		int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		int[][] answer = solution(5, build_frame);
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i][0] + " ");
			System.out.print(answer[i][1] + " ");
			System.out.print(answer[i][2] + " ");
			System.out.println();
		}
	}
}
