package quki.algorithm.bitmask;

import java.util.Scanner;
/**
 * 1<<0   ->   1
 * 1<<2   ->   4
 * 
 * @author quki
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int path = 6;
		System.out.println(path & (1<<n-1));
	}

}
