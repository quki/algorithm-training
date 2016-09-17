package quki.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 그리디 알고리즘 + Object 정렬
 * 
 * @author quki
 *
 */
public class BOJ1931 {

	static class Point {
		int start;
		int end;

		Point(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Point a[] = new Point[n];
		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			a[i] = new Point(start, end);
		}

		Arrays.sort(a, new Comparator<Point>() {

			@Override
			public int compare(Point p1, Point p2) {
				if (p1.end < p2.end) {
					return -1;
				} else if (p1.end == p2.end) {
					if (p1.start < p2.start) {
						return -1;
					} else if (p1.start == p2.start) {
						return 0;
					} else {
						return 1;
					}
				} else {
					return 1;
				}

			}
		});

		int prevEnd = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			Point p = a[i];
			int start = p.start;
			int end = p.end;
			if (prevEnd <= start) {
				prevEnd = end;
				count++;
			}
		}

		System.out.println(count);

	}

}
