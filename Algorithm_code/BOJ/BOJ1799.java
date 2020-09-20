package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1799 {
	public static int size;
    public static int[][] chess;
    
    public static int[] dy = {-1, -1, 1, 1}; // �»�, ���, ����, ����
    public static int[] dx = {-1, 1, -1, 1}; // �»�, ���, ����, ����
    
    public static int b_cnt = 0;
    public static int w_cnt = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        size = Integer.parseInt(br.readLine());
        
        chess = new int[size+1][size+1];
        
        // �Է�
        for(int i=1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j=1; j <= size; j++) {
                chess[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // ��� �ڸ��� �� �� �ִ� ����� ���� Ž���Ѵ�.
        boolean[][] black_visited = new boolean[size+1][size+1];
        black_search(black_visited, 1, 1, 0);
        
        // ��� �ڸ��� �� �� �ִ� ����� ���� Ž���Ѵ�.
        boolean[][] white_visited = new boolean[size+1][size+1];
        white_search(white_visited, 1, 2, 0);
        
        // ���, ��� �ڸ��� �� �� �ִ� ����� ���� ���Ͽ� ����Ѵ�.
        System.out.println(b_cnt+w_cnt);
    }
 
    public static void black_search(boolean[][] visited, int y, int x, int cnt) {
        // �����ڸ��� �� �� �ִ� Ƚ���� ���� Ƚ������ ũ�� ���� �����Ѵ�.
        b_cnt = Math.max(cnt, b_cnt);
        
        // x ǥ�� ü������ ũ�⺸�� ũ�� ��ǥ�� ����ĭ�� ù��° x ��ǥ�� �̵� �����ش�.
        // ��, ��� �ڸ��� y�� Ȧ���� ��� x�� ���� ���� 1���� ���۵ǰ�
        //    ¦���� ��� 2���� ���۵ȴ�.
        if(x > size) {
            y += 1;
            x = (y%2 == 0)?2:1;
        }
        
        // y�� ��ǥ�� ü������ ����� �ʰ��Ұ�� Ž���� �����Ѵ�.
        if(y > size) return;
        
        
        // �����ڸ��� ����� ���� �� �ִ��� Ȯ��
        // �����ڸ��� ����� ���� �� �ִٸ� ����� ���� ���� Ž���� �����Ѵ�.
        // ���� Ž���� ������ ������ x��ǥ�� 2���� ������� �Ѵ�. ������ �� �ڸ��� ���� �ٸ� �ڸ��ϱ�
        // ����� �� ��쿡�� cnt�� 1 ���� ��������Ѵ�.
        if(isAble(visited, y, x)) {
            visited[y][x] = true;
            black_search(visited, y, x+2, cnt+1);
            visited[y][x] = false;
        }
        
        // �����ڸ��� ����� ������ �ִ��� �ȳ������� �ֱ� ������ ����� ���� �ʾ��� ��쿡 ���� Ž���� �����Ѵ�.
        // ���� Ž���� ������ ������ x��ǥ�� 2���� ������� �Ѵ�. ������ �� �ڸ��� ���� �ٸ� �ڸ��ϱ�
        // ����� ���� �ʾ��� ��쿡�� cnt�� ������ų �ʿ䰡 ����.
        black_search(visited, y, x+2, cnt);
    }
    
    public static void white_search(boolean[][] visited, int y, int x, int cnt) {
        // ��� �ڸ��� �� �� �ִ� Ƚ���� ���� Ƚ������ ũ�� ���� �����Ѵ�.
        w_cnt = Math.max(cnt, w_cnt);
        
        // x ǥ�� ü������ ũ�⺸�� ũ�� ��ǥ�� ����ĭ�� ù��° x ��ǥ�� �̵� �����ش�.
        // ��, ��� �ڸ��� y�� Ȧ���� ��� x�� ���� ���� 2���� ���۵ǰ�
        //    ¦���� ��� 1���� ���۵ȴ�.
        if(x > size) {
            y += 1;
            x = (y%2 == 0)?1:2;
        }
        
        // y�� ��ǥ�� ü������ ����� �ʰ��Ұ�� Ž���� �����Ѵ�.
        if(y > size) return;
        
        // �����ڸ��� ����� ���� �� �ִ��� Ȯ��
        // �����ڸ��� ����� ���� �� �ִٸ� ����� ���� ���� Ž���� �����Ѵ�.
        // ���� Ž���� ������ ������ x��ǥ�� 2���� ������� �Ѵ�. ������ �� �ڸ��� ���� �ٸ� �ڸ��ϱ�
        // ����� �� ��쿡�� cnt�� 1 ���� ��������Ѵ�.
        if(isAble(visited, y, x)) {
            visited[y][x] = true;
            white_search(visited, y, x+2, cnt+1);
            visited[y][x] = false;
        }
        
        // �����ڸ��� ����� ������ �ִ��� �ȳ������� �ֱ� ������ ����� ���� �ʾ��� ��쿡 ���� Ž���� �����Ѵ�.
        // ���� Ž���� ������ ������ x��ǥ�� 2���� ������� �Ѵ�. ������ �� �ڸ��� ���� �ٸ� �ڸ��ϱ�
        // ����� ���� �ʾ��� ��쿡�� cnt�� ������ų �ʿ䰡 ����.
        white_search(visited, y, x+2, cnt);
    }
    
    
    public static boolean isAble(boolean[][] visited, int y, int x) {
        if(chess[y][x] == 0) return false; // 0�̸� ���� �� ����.
        
        for(int i=0; i < 4; i ++) {
            int yy = dy[i] + y;
            int xx = dx[i] + x;
            
            for(int j=1; j <= size; j++) {
                if(yy > 0 && xx > 0 && yy <= size && xx <= size) {
                    if(visited[yy][xx]) return false;
                    
                    yy += dy[i];
                    xx += dx[i];
                }
            }
        }
        return true;
    }
}
