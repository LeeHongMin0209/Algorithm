package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class delivery {
	static final int INF = 987654321;
	static int[] dist;
	static int v,e;
	static List<List<Node>> list;
	static class Node implements Comparable<Node>{
		int index, distance;
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		 public int compareTo(Node n) {
	            return this.distance - n.distance;
	       }
	}
	public static void main(String[] args) {
		int N = 5;
		int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
		int K = 3;
		int ans = solution(N, road, K);
		System.out.println(ans);
	}
	static public int solution(int N, int[][] road, int K) {
		int answer = 0;
		v = N;
		e = road.length;
		dist = new int[v+1];
		list = new ArrayList<List<Node>>();
		int start = 1;
		list.add(new ArrayList<Node>());
		Arrays.fill(dist, INF);
		for(int i = 1; i <= v; i++) {
			list.add(new ArrayList<Node>());
		}
		for(int i = 0; i < e; i++) {
			list.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
			list.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
		}
		dijkstra(list, dist, start);
		for(int i = 1; i <= v; i++) {
			if(dist[i] <= K) answer++;
		}
		return answer;
	}	
	static void dijkstra(List<List<Node>> list, int[] distance, int start) {
		//�ּ� heap ���(�ð� ���⵵ ElogE)
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		distance[start] = 0;
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int idx = cur.index;
			int dist = cur.distance;
			//pq���� ���� dist�� �ִܰŸ� ���̺��� ��ġ���� ������ �ѱ�(�ּҰŸ��� �����ϱ����ؼ�)
			if(distance[idx] != dist) continue;
			//list���� idx��°�� �ش��ϴ� List<Node>�鿡 ���� for��(List<Node>�� -> idx���� �� �� �ִ� ������)
			for(Node nxt : list.get(idx)) {
				int cost = nxt.distance;
				int nidx = nxt.index;
				//idx���� �� �� �ִ� �����鿡 ���� �ּҰ� ����
				if(distance[nidx] > dist + cost) {
					distance[nidx] = dist + cost;
					pq.add(new Node(nidx, distance[nidx]));
				}
			}
		}
	}
}
