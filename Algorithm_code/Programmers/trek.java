package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class trek {

	static int min = Integer.MAX_VALUE;
	static int xx[] = {-1, 0, 1, 0};
	static int yy[] = {0, -1, 0, 1};
	static int map[][];
	static int n;
	static int answer;
	
    public static int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        n = board.length;
        map = board;
        
        // �ʱ� ������ -1 �� �ִ� ������ �ڵ����� �����Ҷ� �����ʰ� �Ʒ��� �Ѵ� �̵��Ҽ� �ֱ� �����̴�.
        bfs(0, 0, 0, -1);
        return answer;
    }   
    
    public static void bfs(int x, int y, int cost, int dir) {
    	
    	Queue<Road> q = new LinkedList<Road>();
    	q.add(new Road(x, y, cost, dir));
    	// ��������� 1 �� �ٲپ� Ž������ �����Ѵ�.
    	map[x][y] = 1;
    	
    	while(!q.isEmpty()) {
    		
    		
    		Road temp = q.poll();
    		// �������� �����ߴٸ� �ּҺ���� �������ش�.
    		if(temp.x == n - 1 && temp.y == n - 1) {
    			answer = Math.min(answer, temp.cost);
    			continue;
    		}
    
    		// 4�������� �̵��Ҽ��ִ� .
    		for(int i = 0; i < 4; i++) {
    			int new_x = temp.x + xx[i];
    			int new_y = temp.y + yy[i];
    			// ���� �̵��ϴ� ���� �������̰� ����(1) �ƴϿ����Ѵ�.
    			if(new_x >= 0 && new_x < n && new_y >= 0 && new_y < n && map[new_x][new_y] != 1) {
    				int new_cost = 0;
    				// ���ο� ������ ��뱸�ϱ�.
    				if(temp.dir == -1 || temp.dir == i) {
    					new_cost = temp.cost + 100;
    				}else if(temp.dir != i){
    					new_cost = temp.cost + 600;
    				}
    			
    				//ó������ ���̶�� ������ �־��ָ�ȴ�.
    				if(map[new_x][new_y] == 0) {
    					map[new_x][new_y] = new_cost;
    					q.add(new Road(new_x, new_y, new_cost, i));
    				}else if(map[new_x][new_y] >= new_cost) { //ó�������ʴ� ���̶�� ����� ���۰ų� ���� ��� �־��ָ�ȴ�.
    					map[new_x][new_y] = new_cost;
    					q.add(new Road(new_x, new_y, new_cost, i));
    				}
    				
    				
    			}
    		}
    		
    	}
    }
}


class Road{
	int x,y,cost,dir;
	public Road(int x, int y, int cost, int dir) {
		this.x = x;
		this.y = y;
		this.cost = cost;
		this.dir = dir;
	}
}


