package quki.algorithm.sort;

public class QuickSortRevised {
	static void swap(int idx1, int idx2, int arr[]) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	static void quickSort(int start, int end, int[] arr) {
		int left = start;
		int right = end;
		int pivot = arr[(start + end) / 2];
		
		while(left<=right){
			while (arr[left] < pivot) // pivot과 같으면 stop
				left++;
			while (arr[right] > pivot) // pivot과 같으면 stop
				right--;
			if (left <= right) {
				swap(left, right, arr);
				left++;
				right--;
			}
		}

		if (start < right) // 같으면 sort할 필요 없으므로
			quickSort(start, right, arr);
		if (end > left)
			quickSort(left, end, arr);
	}

	public static void main(String[] args) {

		int arr[] = { 66, 10, 1, 34, 5, -10, -30, -66 };

		quickSort(0, arr.length - 1, arr);

		for (int e : arr) {
			System.out.print(e + " ");
		}
	}

}
