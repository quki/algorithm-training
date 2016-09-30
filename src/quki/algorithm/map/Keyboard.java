package quki.algorithm.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Keyboard {

	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		// 기본적으로 두개의 키보드를 HashMap으로 만듭니다.
		// 두개의 HashMap은 연결되어있습니다.
		HashMap<Integer, String> num = new HashMap<>(); // key: 숫자 (우측 키보드), val: charSet
		HashMap<String, Integer> charSet = new HashMap<>(); // key: 문자(길이==1), val: 우측 키보드에 대응되는 숫자

		// HashMap 초기화
		num.put(0, ",.?!");
		num.put(1, "_");
		num.put(2, "abc");
		num.put(3, "def");
		num.put(4, "ghi");
		num.put(5, "jkl");
		num.put(6, "mno");
		num.put(7, "pqrs");
		num.put(8, "tuv");
		num.put(9, "wxyz");

		charSet.put("h", 4);
		charSet.put("i", 4);
		charSet.put("d", 3);
		charSet.put("a", 2);
		charSet.put("r", 7);
		charSet.put("k", 5);
		
		// 출력하기 위함
		StringBuffer ans = new StringBuffer();
		
		// input의 모든 character를 검사합니다
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			String key = Character.toString(c); // char -> String
			int numKey = charSet.get(key); // 해당 문자(길이==1)에 대응되는 우측 키보드의 숫자
			String strSet = num.get(numKey); // 왼쪽 키보드에서 찾아줌
			
			// strSet에서 내가 원하는 char가 몇번째 있는지 알아야하고
			// 횟수만큼 append
			for (int j = 0; j < strSet.length(); j++) {
				ans.append(charSet.get(key));
				if (key.equals(String.valueOf(strSet.charAt(j)))) {
					break;
				}
			}
		}
		
		System.out.println(ans);

	}

}
