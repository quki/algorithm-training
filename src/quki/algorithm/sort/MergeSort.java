package quki.algorithm.sort;

/**
 * MergeSort, O(NlogN): logN(병합) * N(비교연산)
 */
public class MergeSort {

	/**
	 * MergeTwoArea
	 */
	public static void mergeTwoArea(int start, int mid, int end, int a[]) {
		int left = start;
		int leftEnd = mid;
		int right = mid + 1;
		int rightEnd = end;

		int temp[] = new int[a.length];
		int tIdx = start;
		while (left <= leftEnd && right <= rightEnd) {

			if (a[left] < a[right]) {
				// 우선 순위가 left 가 높은 상황, 오름차순이므로
				temp[tIdx] = a[left];
				left++;
				tIdx++;
			} else if (a[left] > a[right]) {
				// 우선 순위가 right가 높은 상황, 오름차순이므로
				temp[tIdx] = a[right];
				right++;
				tIdx++;
			} else {
				// 우선순의가 left, right가 같은 상황
				temp[tIdx] = a[left];
				left++;
				tIdx++;
				temp[tIdx] = a[right];
				right++;
				tIdx++;
			}
		}

		if (left <= leftEnd) {
			for (int i = left; i <= leftEnd; i++) {
				temp[tIdx] = a[i];
				tIdx++;
			}
		} else {
			for (int i = right; i <= rightEnd; i++) {
				temp[tIdx] = a[i];
				tIdx++;
			}
		}

		for (int i = start; i <= end; i++) {
			a[i] = temp[i];
		}

	}

	/**
	 * MergeSort
	 */
	public static void mergeSort(int start, int end, int a[]) {

		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid, a);
			mergeSort(mid + 1, end, a);
			mergeTwoArea(start, mid, end, a);
		}

	}

	public static void main(String[] args) {
		int a[] = { 3, 6, 2, -1 };
		// int a[] = { 3, 3, 3};
		mergeSort(0, a.length - 1, a);
		for (int e : a) {
			System.out.println(e);
		}

	}

}
