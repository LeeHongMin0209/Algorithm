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
        int current = START_DATE; // 기준. 초기값은 301(3월1일)
        while (current < END_DATE) { // 기준이 11월30일을 넘어서면 stop
            int max = current;
            for (int key : flower.keySet()) { // 전체 꽃을 돌면서
                if (key <= current && max < flower.get(key)) { 
                    // 여기가 핵심이다.
                    // 기준 날짜보다 먼저 피는(기준날짜도 포함해서) 꽃들 중에서, 가장 날짜가 멀리 있는 꽃을 찾는다.
                    max = flower.get(key); 
                    flag = true;
                }
            }

            if (flag) { // 정상처리 되었다면, 가장 먼 날짜를 기준으로 변경한다.
                current = max;
                flag = false;
                count++;
            } else { // flag가 false라는 것은, 기준이 변경되지 않았음을 의미한다.
                     // 따라서, 비정상인 경우이므로 count를 0으로 초기화하고 loop를 중단한다.
                count = 0;
                break;
            }
            
        }

        System.out.println(count);
	}

}
