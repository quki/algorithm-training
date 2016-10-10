package quki.algorithm.graph.search.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1759 {
	static int L;
	static int C;
	/**
	 * 재귀
	 * @param full 원본 문자열
	 * @param making 만들어진 문자열
	 */
	static void go(String full, String making){
		
		if(making.length() == L){
			
			int aCount = 0;
			int splCount = 0;
			//최소 한개의 모음과 최소 두개의 자음(문제조건)
			for(int i = 0; i<L; i++){
				char c = making.charAt(i);
				if(c == 'a' || c == 'e'|| c == 'i'|| c == 'o'|| c == 'u'){
					aCount++;
				}else{
					splCount++;
				}
			}
			if(aCount >=1 && splCount >=2)
				System.out.println(making);
			
			return;
		}
		
		int currIdx = full.indexOf(making.charAt(making.length()-1)); // indexOf 함수: 해당 char의 index를 리턴
		for(int next = currIdx + 1; next <= C-1; next++){
			StringBuilder temp = new StringBuilder(making);
			temp.append(full.charAt(next));
			go(full, temp.toString());
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt(); // 만들어야하는 길이
		C = sc.nextInt(); // 주어진 문자열의 개수
		char a[] = new char[C];
		for(int i = 0; i<C;i++){
			a[i] = sc.next().charAt(0);
		}
		Arrays.sort(a); // 오름차순 정렬
		String full = String.valueOf(a);
		
		for(int start = 0; start <= C-L; start++){
			go(full, Character.toString(full.charAt(start)));
		}
	}

}
