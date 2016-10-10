package quki.algorithm.string;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ9933 {

	public static String reverse(String input){
		char[] arr = input.toCharArray();
		for(int i = 0; 2*i<input.length();i++){
			char temp = arr[i];
			arr[i] = arr[input.length()-1-i];
			arr[input.length()-1-i] = temp;
		}
		return String.valueOf(arr);
		
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		String a[] = new String[N];
		HashSet<String> hs = new HashSet<>();
		for(int i = 0; i<N; i++){
			String input = sc.nextLine();
			a[i] = input;
			hs.add(input);
		}
		
		for(int i = 0; i<N;i++){
			if(hs.contains(reverse(a[i]))){
				System.out.println(a[i].length());
				System.out.println(a[i].charAt(a[i].length()/2));
				break;
			}
				
		}
	}

}
