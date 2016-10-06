package quki.algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10988 {

	static int isPelindrome(int[][] dp, String str, int start, int end){
		if(dp[start][end] != -1)
			return dp[start][end];
		
		if(start == end)
			return dp[start][end] = 1;
		
		if(start+1 == end){
			if(str.charAt(start) == str.charAt(end)){
				return dp[start][end] = 1;
			}else{
				return dp[start][end] = 0;
			}
		}
		
		if(str.charAt(start) == str.charAt(end)){
			return dp[start][end] = isPelindrome(dp, str, start+1, end-1);
		}else{
			return dp[start][end] = 0;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int dp[][] = new int[str.length()][str.length()];
		
		for(int i = 0; i<dp[0].length;i++){
			Arrays.fill(dp[i], -1);	
		}
		
		if(isPelindrome(dp, str, 0, str.length()-1) == 1){
			System.out.println(1);
		}else{
			System.out.println(0);
		}
		
	}

}
