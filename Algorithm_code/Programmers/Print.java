package Programmers;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Print {

    static public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Num> list = new LinkedList<>();
        
        int size = priorities.length;
        for(int i = 0; i < size; i++) {
        	list.add(new Num(priorities[i], i));      	
        }
        int ans = 1;
        while(!list.isEmpty()) {
        	int lSize = list.size();
        	boolean check = false;
        	for(int i = 1; i < lSize; i++) {
        		if(list.get(0).num < list.get(i).num) check = true;
        	}
        	if(check) {
        		Num x = list.get(0);
        		list.add(x);
        		list.remove(0);
        	}
        	else {
        		if(list.get(0).location == location) break;
        		list.remove(0);
        		ans++;
        	}
        }
        answer = ans;
        return answer;
    }
    
    static class Num{
    	int num;
    	int location;
    	Num(int num, int location){
    		this.num = num;
    		this.location = location;
    	}
    }
    public static void main(String[] args) {
		int[] arr = {1,1,9,1,1,1};
		int lo = 0;
		int ans = solution(arr, lo);
		System.out.println(ans);
	}
}
