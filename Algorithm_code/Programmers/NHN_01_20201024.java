package Programmers;

import java.util.ArrayList;
import java.util.Scanner;

public class NHN_01_20201024 {
	static class player {
		char name;
		boolean fast;
		int num = 0;
		public player(char name, boolean fast, int num) {
			this.name = name;
			this.fast = fast;
			this.num = num;
		}
	}
	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
		ArrayList<player> list = new ArrayList<>();
		for(int i = 65; i < numOfAllPlayers+65; i++) {
			int tmp = i;
			char name = (char) tmp;
			boolean check = false;
			for(int j = 0; j < numOfQuickPlayers; j++) {
				if(name == namesOfQuickPlayers[j]) {
					check = true;
				}
			}
			list.add(new player(name, check, 0));
		}
		
		int start = 1;
		int end = 0;
		list.set(0, new player('A', false, 1));
		for(int i = 0; i < numOfGames; i++) {
			player p1 = list.get(0);
			int dis = numOfMovesPerGame[i];
			if(dis >= 0) {
				if(dis+start < list.size()) {
					end = dis + start;
				} else if(dis + start > list.size()){
					end = (dis + start) % (list.size()-1); 
				} else if(dis+start == list.size()) {
					end = 1;
				}
			}
			else if(dis < 0) {
				if(dis + start == 0) end = list.size() - 1;
				else if(dis + start > 0) end = dis + start;
				else if(dis + start < 0) {
					while(true) {
						if(start > 0) {
							start--;
						}
						if(start == 0) {
							start = list.size()-1;
						}
						dis++;
						if(dis == 0) break;
					}
					end = start;
				}
			}
			player p2 = list.get(end);
			if(p2.fast) {
				list.set(0, new player(p1.name, p1.fast, p1.num + 1));
			} else if(!p2.fast) {
				list.set(0, new player(p2.name, p2.fast, p2.num + 1));
				list.set(end, new player(p1.name, p1.fast, p1.num));
				start = end;
			}
		}
		for(int i = 1; i < list.size(); i++) {
			System.out.println(list.get(i).name + " " + list.get(i).num);
		}
		System.out.println(list.get(0).name + " " + list.get(0).num);
	}
	
	private static class InputData {
		int numOfAllPlayers;
		int numOfQuickPlayers;
		char[] namesOfQuickPlayers;
		int numOfGames;
		int[] numOfMovesPerGame;
	}
	
	private static InputData processStdin() {
		InputData inputData = new InputData();
		
		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			
			inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
			System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);
			
			inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.numOfMovesPerGame = new int[inputData.numOfGames];
			String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
			for(int i = 0; i < inputData.numOfGames ; i++){
				inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
			}
		} catch (Exception e) {
			throw e;
		}
		
		return inputData;
	}
	
	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();
		
		solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
	}
}
