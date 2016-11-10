package quki.algorithm.string;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ1672 {

	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<>();
		hm.put("AA", "A");
		hm.put("AC", "A");
		hm.put("CA", "A");
		hm.put("GT", "A");
		hm.put("TG", "A");
		
		hm.put("GG", "G");
		hm.put("AT", "G");
		hm.put("CT", "G");
		hm.put("TA", "G");
		hm.put("TC", "G");
		
		hm.put("AG", "C");
		hm.put("GA", "C");
		hm.put("CC", "C");
		
		hm.put("GC", "T");
		hm.put("CG", "T");
		hm.put("TT", "T");
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		char[] strArray = str.toCharArray();
		for(int i = strArray.length-2; i>=0; i--){
			char prev = strArray[i];
			char curr = strArray[i+1];
			StringBuilder key = new StringBuilder();
			key.append(prev);
			key.append(curr);
			String replace = hm.get(key.toString());
			char c = replace.charAt(0);
			strArray[i+1] = 0;
			strArray[i] = c;
		}
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i<strArray.length; i++){
			char c = strArray[i];
			if(c != 0){
				ans.append(c);
			}
		}
		System.out.println(ans.toString());
		
		
	}

}
