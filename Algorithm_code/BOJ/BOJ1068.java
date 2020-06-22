package BOJ;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ1068 {
	
	
	static int N;
	static int[][] nodes;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		nodes=new int[N][2];//0�θ��� 1�ڽļ�
		for(int i=0; i<N; i++) {
			nodes[i][0]=sc.nextInt();
		}
		getChildNum();
		remove(sc.nextInt());
		System.out.println(getAnswer());
	}

	private static int getAnswer() {
		int cnt=0;
		for(int i=0; i<N; i++) {
			if(nodes[i][0]!=-2 &&nodes[i][1]==0) {
				cnt++;
			}
		}
		return cnt;
	}

	private static void remove(int num) {
		if(nodes[num][0]!=-1) {//��Ʈ���ƴϸ�
			nodes[nodes[num][0]][1]--;//�θ����� �ڽļ� ���̱�
		}
		nodes[num][0]=-2;//������ ��� ǥ��
		if(nodes[num][1]>0) {//�ڽ��� ������
			for(int i=0; i<N; i++) {
				if(nodes[i][0]==num) {
					remove(i);
				}
			}
		}
		
	}

	private static void getChildNum() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(nodes[j][0]==i) nodes[i][1]++;
			}
		}
		
	}
}
