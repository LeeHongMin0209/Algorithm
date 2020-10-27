package BOJ;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ2457 {
	public static int getCalendarDate(String month, String date) {
		return (Integer.parseInt(month) * 100) + Integer.parseInt(date);
		
	}
	public static void main(String[] args) {
		final int START_DATE = 301;
        final int END_DATE = 1201;
        
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int count = 0;
        
        HashMap<Integer, Integer> flower = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String[] rawDate = sc.nextLine().split(" ");
            int start = getCalendarDate(rawDate[0], rawDate[1]); 
            int end = getCalendarDate(rawDate[2], rawDate[3]);
            
            if (flower.get(start) == null || flower.get(start) < end) { 
                flower.put(start, end);
            }
        }
        boolean flag = false;
        int current = START_DATE; // ����. �ʱⰪ�� 301(3��1��)
        while (current < END_DATE) { // ������ 11��30���� �Ѿ�� stop
            int max = current;
            for (int key : flower.keySet()) { // ��ü ���� ���鼭
                if (key <= current && max < flower.get(key)) { 
                    // ���Ⱑ �ٽ��̴�.
                    // ���� ��¥���� ���� �Ǵ�(���س�¥�� �����ؼ�) �ɵ� �߿���, ���� ��¥�� �ָ� �ִ� ���� ã�´�.
                    max = flower.get(key); 
                    flag = true;
                }
            }

            if (flag) { // ����ó�� �Ǿ��ٸ�, ���� �� ��¥�� �������� �����Ѵ�.
                current = max;
                flag = false;
                count++;
            } else { // flag�� false��� ����, ������ ������� �ʾ����� �ǹ��Ѵ�.
                     // ����, �������� ����̹Ƿ� count�� 0���� �ʱ�ȭ�ϰ� loop�� �ߴ��Ѵ�.
                count = 0;
                break;
            }
            
        }

        System.out.println(count);
	}

}
