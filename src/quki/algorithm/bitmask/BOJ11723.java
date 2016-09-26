package quki.algorithm.bitmask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ11723 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strN =  br.readLine();
		int  N = Integer.parseInt(strN);
		int s = 0;
		int m = 20;
		StringBuffer sb = new StringBuffer();
		while (N-- > 0) {
			String line = br.readLine();
			String array[] = line.split(" ");
			String cmd = array[0];
			int x = 0;
			if (array.length >= 2) {
				x = Integer.parseInt(array[1]);
			}

			if (cmd.equals("add")) {
				x--;
				s = (s | (1 << x));
			} else if (cmd.equals("check")) {
				x--;
				int res = (s & (1 << x));
				if (res != 0) {
					sb.append(1);
					sb.append("\n");
				} else {
					sb.append(0);
					sb.append("\n");
				}
			} else if (cmd.equals("remove")) {
				x--;
				s = (s & ~(1 << x));
			} else if (cmd.equals("toggle")) {
				x--;
				s = (s ^ (1 << x));
			} else if (cmd.equals("empty")) {
				s = 0;
			} else if (cmd.equals("all")) {
				s = (1 << m) - 1;
			}

		}
		System.out.println(sb);

	}

}
