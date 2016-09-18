package quki.algorithm.greedy;

import java.util.Scanner;
/**
 * 병든 나이트 문제
 * 문제를 이해하는데 다소 어려움
 * 여러 경우를 나누는 문제
 * 그닥 중요도가 높은 문제는 아닌듯
 * 
 * @author quki
 *
 */
public class BOJ1783 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 높이
		int M = sc.nextInt(); // 너비
		int ans = 0;
		if(N == 1){
			ans = 1;
		}else if(N == 2){
			ans = Math.min(4, (M+1)/2);
		}else if(N>=3){
			if(M>=7){
				ans = M-2;
			}else{
				ans = Math.min(4, M);
			}
		}
		System.out.println(ans);
	}

}
