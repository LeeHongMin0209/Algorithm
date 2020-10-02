package Programmers;

import java.util.ArrayList;

public class visitedLength {
	static class dot{
		int x;
		int y;
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] map = new int[11][11];
	static public int solution(String dirs) {
        int answer = 0;
        char[] str = dirs.toCharArray();
        dot cur = new dot(5, 5);
        ArrayList<dot[][]> list = new ArrayList<>();
        for(int i = 0; i < dirs.length(); i++) {
        	if(str[i] == 'U') {
        		int x = cur.x;
        		int y = cur.y + 1;
        		if(isRanged(x, y)) {
        			if(checkMap(x, y, cur.x, cur.y, list)) {
        				dot[][] drr = new dot[1][2];
        				dot d1 = new dot(cur.x, cur.y);
        				dot d2 = new dot(x, y);
        				drr[0][0] = d1;
        				drr[0][1] = d2;
        				list.add(drr);
        			}
        			cur.x = x;
        			cur.y = y;
        		}
        	} else if(str[i] == 'L') {
        		int x = cur.x - 1;
        		int y = cur.y;
        		if(isRanged(x, y)) {
        			if(checkMap(x, y, cur.x, cur.y, list)) {
        				dot[][] drr = new dot[1][2];
        				dot d1 = new dot(cur.x, cur.y);
        				dot d2 = new dot(x, y);
        				drr[0][0] = d1;
        				drr[0][1] = d2;
        				list.add(drr);
        			}
        			cur.x = x;
        			cur.y = y;
        		}
        	} else if(str[i] == 'R') {
        		int x = cur.x + 1;
        		int y = cur.y;
        		if(isRanged(x, y)) {
        			if(checkMap(x, y, cur.x, cur.y, list)) {
        				dot[][] drr = new dot[1][2];
        				dot d1 = new dot(cur.x, cur.y);
        				dot d2 = new dot(x, y);
        				drr[0][0] = d1;
        				drr[0][1] = d2;
        				list.add(drr);
        			}
        			cur.x = x;
        			cur.y = y;
        		}
        	} else if(str[i] == 'D') {
        		int x = cur.x;
        		int y = cur.y - 1;
        		if(isRanged(x, y)) {
        			if(checkMap(x, y, cur.x, cur.y, list)) {
        				dot[][] drr = new dot[1][2];
        				dot d1 = new dot(cur.x, cur.y);
        				dot d2 = new dot(x, y);
        				drr[0][0] = d1;
        				drr[0][1] = d2;
        				list.add(drr);
        			}
        			cur.x = x;
        			cur.y = y;
        		}
        	}
        }
        answer = list.size();
        return answer;
    }
	static boolean isRanged(int x, int y) {
		if(x < 0 || x > 10 || y < 0 || y > 10) return false;
		return true;
	}
	static boolean checkMap(int x1, int y1, int x2, int y2, ArrayList<dot[][]> list) {
		for(int i = 0; i < list.size(); i++) {
			dot[][] drr = list.get(i);
			int xx1 = drr[0][0].x;
			int yy1 = drr[0][0].y;
			int xx2 = drr[0][1].x;
			int yy2 = drr[0][1].y;

			if(xx1 == x1 && yy1 == y1) {
				if(xx2 == x2 && yy2 == y2) {
					return false;
				}
			} else if(xx2 == x1 && yy2 == yy1) {
				if(xx1 == x2 && yy1 == y2) {
					return false;
				}
			} else if(xx1 == x2 && yy1 == y2) {
				if(xx2 == x1 && yy2 == y1) {
					return false;
				}
			} else if(xx2 == x2 && yy2 == y2) {
				if(xx1 == x1 && yy1 == y1) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String dirs = "ULURRDLLU";
		int ans = solution(dirs);
		System.out.println(ans);
	}
}
