package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import BOJ.BOJ11651.dot;

class BOJ10814 {
	static class user{
		int age;
		String name;
		int idx;
		public user(int age, String name, int idx) {
			this.age = age;
			this.name = name;
			this.idx = idx;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		user[] list = new user[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			user u = new user(age, name, i);
			list[i] = u;
		}
		 Arrays.sort(list, new Comparator<user>() {
	        	public int compare(user o1, user o2) {
	                if(o1.age != o2.age) {
	                	//Double 인수 정렬할때는 다음과 같이
	                    return (o1.age - o2.age);
	                }
	                //int 인수 정렬은 다음과 같이
	                return o1.idx- o2.idx;
	            }
	        });
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(list[i].age + " " + list[i].name + "\n");
		}
		System.out.println(sb.toString());
	}

}
