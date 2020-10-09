package Programmers;

public class baseInstallation {
	public static void main(String[] args) {
		int n = 11;
		int[] stations = {4,11};
		int w = 1;
		int ans = solution(n, stations, w);
		System.out.println(ans);
	}
	static public int solution(int n, int[] stations, int w) {
		int answer = 0;	// 기지국의 갯수
		int si = 0;	// station의 인덱스
		int position = 1;	// 아파트 1동부터 끝까지 
		while(position <= n) {	// 동 전체을 돌면서	
	    
			// 기지국이 설치된(stations 배열의 요소가 존재할 때 까지) 곳 까지만 탐색
	                // 현재의 위치(posotion)가 기존 설치된 기지국(stations[si])의 전파 범위(w) 안에 있는지 확인
	                // 만약 기존 설치된 기지국의 범위 안에 있을경우 => 전파 범위이므로 기지국을 설치할 필요가 없다.
			if(si < stations.length && position >= stations[si] - w) {
				// 다음 이동해야 할 포지션
				position = stations[si] + w + 1;	// 기지국의 오른쪽 끝
				si ++;	// 다음 설치한 기지국을 찾기 위해 인덱스 +1
	 		}
			else {
				answer += 1;	// 기지국 하나 설치
				
				// 기지국 설치에 의해 발생하는 최대 전파범위
				// 왼쪽 전파범위 + 기지국설치(1) + 오른쪽 전파범위
				position += (w*2) + 1;
			}
		}
		return answer;
	}	
}
