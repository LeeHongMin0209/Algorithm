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
		int answer = 0;	// �������� ����
		int si = 0;	// station�� �ε���
		int position = 1;	// ����Ʈ 1������ ������ 
		while(position <= n) {	// �� ��ü�� ���鼭	
	    
			// �������� ��ġ��(stations �迭�� ��Ұ� ������ �� ����) �� ������ Ž��
	                // ������ ��ġ(posotion)�� ���� ��ġ�� ������(stations[si])�� ���� ����(w) �ȿ� �ִ��� Ȯ��
	                // ���� ���� ��ġ�� �������� ���� �ȿ� ������� => ���� �����̹Ƿ� �������� ��ġ�� �ʿ䰡 ����.
			if(si < stations.length && position >= stations[si] - w) {
				// ���� �̵��ؾ� �� ������
				position = stations[si] + w + 1;	// �������� ������ ��
				si ++;	// ���� ��ġ�� �������� ã�� ���� �ε��� +1
	 		}
			else {
				answer += 1;	// ������ �ϳ� ��ġ
				
				// ������ ��ġ�� ���� �߻��ϴ� �ִ� ���Ĺ���
				// ���� ���Ĺ��� + ��������ġ(1) + ������ ���Ĺ���
				position += (w*2) + 1;
			}
		}
		return answer;
	}	
}
