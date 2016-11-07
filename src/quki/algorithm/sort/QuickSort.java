package quki.algorithm.sort;

public class QuickSort {

	public static void swap(int idx1, int idx2, int a[]) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	public static int getPivot(int start, int end, int a[]) {

		int pivot = a[start];
		int low = start + 1;
		int high = end;

		while (low <= high) {
			while (pivot >= a[low] && low <= end) {
				low++;
			}

			while (pivot <= a[high] && high >= (start + 1)) {
				high--;
			}

			if (low <= high) {
				swap(low, high, a);
			}

		}
		swap(start, high, a);
		return high;
	}

	public static void quickSort(int start, int end, int a[]) {

		if (start <= end) {
			int pivot = getPivot(start, end, a);
			quickSort(start, pivot - 1, a);
			quickSort(pivot + 1, end, a);
		}

	}

	public static void main(String[] args) {
		int a[] = { 3, 6, 2, -1, 5, 7, -4, -10 };
		quickSort(0, a.length - 1, a);
		for (int e : a) {
			System.out.println(e);
		}
	}

}
