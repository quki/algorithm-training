package quki.algorithm.dp;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ2352Faster {

	static int findSameorBig(ArrayList<Integer> T,  int target) {
		int ans = 0;
		int left = 0; 
		int right = T.size()-1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (T.get(mid) > target) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int In[] = new int[n];
		for(int i = 0; i<n;i++){
			In[i] = sc.nextInt();
		}
		ArrayList<Integer> T = new ArrayList<>();
		int result[] = new int[n];
		T.add(In[0]);
		for(int i = 1;i<n;i++){
			if(T.get(T.size()-1) < In[i]){
	            T.add(In[i]);
	            result[i] = In[i];
	        } else if (T.get(0) > In[i]){
	        	T.remove(0);
	            T.add(0, In[i]);
	        } else {
	            int idx = findSameorBig(T, In[i]);
	            T.remove(idx);
	            T.add(idx, In[i]);
	            result[i] = T.get(idx-1);
	        }
		}
		for(int e: result){
			System.out.println(e);
		}
	}

}

