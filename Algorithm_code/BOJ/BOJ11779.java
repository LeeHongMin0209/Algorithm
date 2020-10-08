package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class BOJ11779 {

	static final int INF = 987654321;
	static int v,e;
	//�ִܰŸ� ���̺�
	static int[] dist;
	//list�� Node List�� ���� List
	static List<List<Node>> list;
	//��� ��� �迭
	static int[] pre = new int[10005];
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
		
		v = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());
		dist = new int[v+1];
		list = new ArrayList<List<Node>>();
		
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
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(list, dist, start);
		bw.write(dist[end] + "\n");
		Vector<Integer> path = new Vector<>();
		int cur = end;
		//pre�迭�� ������ ���󰡸鼭 ���Ϳ� ����
		while(cur != start) {
			path.add(cur);
			cur = pre[cur];
		}
		path.add(cur);
		//������ ���󰡸鼭 �����߱� ������ ���͸� reverse ����� �������� ���� ��°���
		Collections.reverse(path);
		bw.write(path.size() + "\n");
		for(int x : path) {
			bw.write(x + " ");
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
					//���� �ɶ����� ��� �Է�
					pre[nidx] = idx;
				}
			}
		}
	}

}
