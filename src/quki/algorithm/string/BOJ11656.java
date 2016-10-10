package quki.algorithm.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ11656 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		ArrayList<String> al = new ArrayList<>();
		for(int i = 0 ; i<input.length();i++){
			String tail = input.substring(i, input.length());
			al.add(tail);
		}
		
		Collections.sort(al);
		StringBuilder ans = new StringBuilder();
		for(String tail: al){
			ans.append(tail+"\n");
		}
		System.out.print(ans);
		
	}

}
