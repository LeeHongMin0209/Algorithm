package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1963 {
	private static final String SPACE = " ";
	private static final String END_LINE = "\n";
	private static final String NO = "Impossible";

	private static final int INF = 10_000;
	private static final int[] NUMS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	private static boolean[] isPrime = null;
	private static int[] isVisited = null;

	private static int prime1 = 0;
	private static int prime2 = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

        prime();	

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
			prime1 = Integer.parseInt(st.nextToken());
			prime2 = Integer.parseInt(st.nextToken());

			isVisited = new int[INF];

			int result = 0;

			if (prime1 != prime2) {	
				result = bfs();
			}

			sb.append(result == -1 ? NO : result).append(END_LINE);	
		}
		System.out.println(sb.toString());
	}
	
	private static void prime() {
        isPrime = new boolean[INF];
		Arrays.fill(isPrime, true);
        
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i < INF; i++) {
            if(!isPrime[i]) continue;
			for (int j = i + i; j < INF; j += i) {
				isPrime[j] = false;
			}
		}
	}
	
	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(prime1);

		isVisited[prime1] = 1;

		while (!q.isEmpty()) {
			int current = q.poll();
			int uni = current - (current % 10);							
			int ten = current - ((current % 100) - (current % 10));		
			int hun = current - ((current % 1000) - (current % 100));	
			int tho = current - (current / 1000 * 1000);	
			
			int[] nextSet = {tho, hun, ten, uni};	
			for(int i = 0; i < nextSet.length; i++){
				int next = 0;
				
				for (final int N: NUMS) {
                    next = nextSet[i] + (N * (int) (Math.pow(10, 3 - i)));
	
					if (next > 1000 && next < INF && isPrime[next]) {
						if (isVisited[next] == 0) {					
							isVisited[next] = isVisited[current] + 1;
			
							if (next == prime2) {			
								return isVisited[next] - 1;
							}
			
							q.offer(next);
						}
					}
				}
			}
		}   
		
		return -1;
	}
}