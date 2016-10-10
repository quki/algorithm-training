package quki.algorithm.string;

import java.util.Scanner;

public class BOJ5598 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i<input.length();i++){
			int c = input.charAt(i);
			int newC = c-3;
			if(newC < 65){
				newC = 91 - (65 - newC);
			}
			ans.append((char)newC);
		}
		
		System.out.println(ans);
		
		
	}

}
