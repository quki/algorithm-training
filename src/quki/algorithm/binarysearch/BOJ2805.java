package quki.algorithm.binarysearch;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 이진탐색!
 * 
 * isPossible에서
 * long을 쓰는 이유
 * 
 * 
 * @author quki
 *
 */
public class BOJ2805 {

	public static boolean isPossible(int[] a, int M, int mid){
		
		long toHome = 0; // a의 원소들은 모두 1,000,000,000 이하이지만, 합은 넘을 수 있다.
		for(int tree: a){
			if(tree > mid){
				toHome += (tree - mid);
			}
		}

		return toHome >= M;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}

		Arrays.sort(a);
		int left = 0;
		int right = a[N - 1];
		int ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if(isPossible(a,M,mid)){
				// 가져가는 나무를 약간 줄이고,
				// 톱의 높이를 조금 올려보자
				left = mid + 1;
				ans = Math.max(ans,mid);
			}else{
				// 가져가는 나무를 늘리기 위해,
				// 톱의 높이를 조금 낮춰보자
				right = mid -1;
			}
		}
		
		System.out.println(ans);
	}

}
