package quki.algorithm.greedy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 그리디 문제 + 문자열 나누기
 * 
 * @author quki
 *
 */
public class BOJ1541 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		// 두 배열의 길이는 같아야한다.
		ArrayList<String> num = new ArrayList<>(); // 숫자 저장
		ArrayList<String> sign = new ArrayList<>(); // 그 숫자에 대한 부호 저장
		sign.add("+"); // 문제 조건에 의해 첫째항은 무조건 + 이므로
		String temp = "";
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == '+' || c == '-') {
				sign.add(String.valueOf(c));
				num.add(temp);
				temp = "";
			} else {
				temp += c;
			}
		}
		// 마지막에 저장한 값 배열에 저장
		if (!temp.equals("")) {
			num.add(temp);
		}
		int ans = 0;
		boolean isMinus = false; // 음수가 한번 나오기 시작하면 그 이후부턴 모두 빼주면 됨
		for (int i = 0; i < num.size(); i++) {
			String s = sign.get(i);
			int a = Integer.parseInt(num.get(i));
			if (!isMinus && s.equals("-")) {
				isMinus = true;
			}
			if (isMinus) {
				ans -= a;
			} else {
				ans += a;
			}

		}

		System.out.println(ans);
	}

}
