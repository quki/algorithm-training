package quki.algorithm.sort;

import java.util.PriorityQueue;

/**
 * 오름차순 정렬, HeapSort O(NlogN)
 * 
 */
public class HeapSort {

	public static void main(String[] args) {
		int a[] = { 3, 6, 2, -1 };

		PriorityQueue<Integer> pq = new PriorityQueue<>(); // MinHeap
		for (int i = 0; i < a.length; i++) { // N
			pq.add(a[i]); // logN
		}
		for (int i = 0; i < a.length; i++) { // N
			int x = pq.poll(); // logN
			a[i] = x;
		}

		for (int e : a) {
			System.out.println(e);
		}

	}

}
