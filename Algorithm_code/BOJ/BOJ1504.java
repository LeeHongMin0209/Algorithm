package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504 {
	static final int INF = 9876543;
	static int v,e;
	//�ִܰŸ� ���̺�
	static int[] dist;
	static int[] pre = new int[10005];

	//list�� Node List�� ���� List
	static List<List<Node>> list;
	
	//�Ÿ��� ������ ���� pair ����
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
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		dist = new int[v+1];
		list = new ArrayList<List<Node>>();
		
		int start = 1;
		//list.get(0)�� ���� �ʱ�ȭ(�� Node�� �־���)
		list.add(new ArrayList<Node>());
		Arrays.fill(dist, INF);
		//list.get(1) ~ list.get(v)������ �ʱ�ȭ(�� Node�� �־���)
		for(int i = 1; i <= v; i++) {
			list.add(new ArrayList<Node>());
		}
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			//�Է¹��� v1��°�� ���� list�� ����
			list.get(v1).add(new Node(v2, cost));
			list.get(v2).add(new Node(v1, cost));
		}
		st = new StringTokenizer(br.readLine());
		int stopOver1 = Integer.parseInt(st.nextToken());
		int stopOver2 = Integer.parseInt(st.nextToken());
		
		
		dijkstra(list, dist, start);
		int tmp1_1 = dist[stopOver1];
		int tmp2_1 = dist[stopOver2];

		
		Arrays.fill(dist, INF);
		dijkstra(list, dist, stopOver1);
		int tmp = dist[stopOver2];
		
		Arrays.fill(dist, INF);
		dijkstra(list, dist, stopOver1);
		int tmp2_2 = dist[v];
		Arrays.fill(dist, INF);
		dijkstra(list, dist, stopOver2);
		int tmp1_2 = dist[v];
		int ans = Math.min(tmp1_1 + tmp1_2, tmp2_1 + tmp2_2) + tmp;
		
		if(ans >= INF) System.out.println(-1);
		else System.out.println(ans);
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
					//���� �ɶ����� ��� �Է�
					pre[nidx] = idx;
				}
			}
		}
	}


}
