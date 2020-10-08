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

public class BOJ1753 {
	static final int INF = 987654321;
	static int v,e;
	//�ִܰŸ� ���̺�
	static int[] dist;
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
		
		int start = Integer.parseInt(br.readLine());
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
		}
		
		dijkstra(list, dist, start);
		
		for(int i = 1; i <= v; i++) {
			if(dist[i] == INF) {
				bw.write("INF\n");
			} else {
				bw.write(dist[i] + "\n");
			}
		}
		bw.flush();
		bw.close();
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
