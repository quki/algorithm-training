
package quki.algorithm.dp;

import java.util.Scanner;

public class Stairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f[] = new int[n];
        int s[] = new int[n];
        for (int i = 1; i <= n; i++) {
            f[i] = sc.nextInt();
            if(i == 1){
                s[i] = f[i];
            }else if(i == 2){
                
            }else if(i == 3){
                
            }
        }
    }

}
