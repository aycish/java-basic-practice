package programmers.hash;

import java.util.HashMap;

public class SecondProblem {
	public static void main(String[] args) {

		/* 참가자 명단 */
		String[][] books = {
			{"119", "97674223", "1195524421"},
			{"123", "456", "789"},
			{"12", "123", "1235", "567", "88"}
		};

		for (int i = 0; i < 3; i++) {
			System.out.println(solution(books[i]));
		}
	}

	public static boolean solution(String[] phoneBook) {
		boolean answer = true;
		HashMap<String, Integer> map = new HashMap<>();

		for (String str : phoneBook) {
			String substr = "";
			for (int i = 1; i < str.length(); i++) {
				substr = str.substring(0, i);
				//System.out.println(substr);
				map.put(substr, 1);
			}
		}

		for (String str : phoneBook) {
			if (map.containsKey(str)) {
				return false;
			}
		}

		return answer;
	}
}
