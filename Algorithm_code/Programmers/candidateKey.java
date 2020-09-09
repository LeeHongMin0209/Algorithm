package Programmers;

public class candidateKey {
	static int ans = 0;
	static public int solution(String[][] relation) {
        int answer = 0;  
        int[] arr = new int[relation[0].length];
        boolean[] visited = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++) {
        	arr[i] = i;
        }
        for(int i = 1; i <= relation.length; i++) {
        	combination(arr, visited, 0, arr.length , i, relation);
        }
        int[] temp = {1};
        unique(temp, relation);
        answer = ans;
        return answer;
    }	
	static boolean unique(int[] arr, String[][] relation) {
		boolean check = true;
		loop : for(int i = 0; i < arr.length; i++) {
			String tmp = relation[0][arr[0]];
			for(int j = 1; j < relation.length; j++) {
				System.out.println(relation[j][arr[i]]);
				if(tmp.equals(relation[j][arr[i]])) {
					System.out.println("equal");
					check = false;
					break loop;
				}
				tmp = relation[j][arr[i]];
			}
		}
		return check;
	}
	static void combination(int[] arr, boolean[] visited, int start, int n, int r, String[][] relation) {
        if (r == 0) {
        	int cnt = 0;
        	for (int i = 0; i < n; i++) {
        		if (visited[i]) cnt++;
        	}
        	int[] arr2 = new int[cnt];
        	int c = 0; 
        	for(int i = 0; i < n; i++) {
        		if(visited[i]) {
        			arr2[c] = arr[i];
        			c++;
        		}
        	}

            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, relation);
            visited[i] = false;
        }
    }
	public static void main(String[] args) {
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		int ans = solution(relation);
		System.out.println(ans);
	}
}
