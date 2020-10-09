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
	//최단거리 테이블
	static int[] dist;
	static int[] pre = new int[10005];

	//list는 Node List에 대한 List
	static List<List<Node>> list;
	
	//거리와 정점에 대한 pair 생성
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
		//list.get(0)에 대한 초기화(빈 Node를 넣어줌)
		list.add(new ArrayList<Node>());
		Arrays.fill(dist, INF);
		//list.get(1) ~ list.get(v)까지의 초기화(빈 Node를 넣어줌)
		for(int i = 1; i <= v; i++) {
			list.add(new ArrayList<Node>());
		}
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			//입력받은 v1번째에 대한 list를 생성
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
		//최소 heap 사용(시간 복잡도 ElogE)
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		distance[start] = 0;
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int idx = cur.index;
			int dist = cur.distance;
			//pq에서 꺼낸 dist와 최단거리 테이블이 일치하지 않으면 넘김(최소거리를 유지하기위해서)
			if(distance[idx] != dist) continue;
			//list에서 idx번째에 해당하는 List<Node>들에 대한 for문(List<Node>들 -> idx에서 갈 수 있는 정점들)
			for(Node nxt : list.get(idx)) {
				int cost = nxt.distance;
				int nidx = nxt.index;
				//idx에서 갈 수 있는 정점들에 대한 최소값 갱신
				if(distance[nidx] > dist + cost) {
					distance[nidx] = dist + cost;
					pq.add(new Node(nidx, distance[nidx]));
					//갱신 될때마다 경로 입력
					pre[nidx] = idx;
				}
			}
		}
	}


}
