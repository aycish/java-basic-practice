package programmers.hash;

import java.util.HashMap;
import java.util.Map;

/* 프로그래머스 Hash 문제 1번 */
public class FisrtProblem {
	public static void main(String[] args) {

		/* 참가자 명단 */
		String[][] part = {
			{"leo", "kiki", "eden"},
			{"marina", "josipa", "nikola", "vinko", "filipa"},
			{"mislav", "stanko", "mislav", "ana"}
		};

		/* 완주자 명단 */
		String[][] com = {
			{"eden", "kiki"},
			{"josipa", "filipa", "marina", "nikola"},
			{"stanko", "ana", "mislav"}
		};

		for (int i = 0; i < 3; i++) {
			System.out.println((solve(part[i], com[i])));
		}
	}

	private static String solve(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<>();
		String answer = "";

		for (String part : participant) {
			if (map.containsKey(part)) {
				int num = map.get(part);
				map.put(part, num + 1);
			} else {
				map.put(part, 1);
			}
		}

		for (String com : completion) {
			if (map.containsKey(com) && map.get(com) > 0) {
				int num = map.get(com);
				map.put(com, num - 1);
			}
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 0) {
				return entry.getKey();
			}
		}
		return answer;
	}
}
