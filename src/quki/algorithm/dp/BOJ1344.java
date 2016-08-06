
package quki.algorithm.dp;

import java.util.Scanner;



public class BOJ1344 {
    public static boolean isPrime(int i){
        
        if(i == 2 || i == 3 || i == 5 || i == 7 || i == 11 || i == 13 || i == 17){
            return true;
        }
        
        return false;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int d[] = new int[19];
        double a[] = new double[19];
        double b[] = new double[19];
        d[0] = 1;
        d[1] = 18;
        double Ateam = A / 100.0;
        double Bteam = B / 100.0;
        for (int i = 2; i <= 18; i++) {
            d[i] = (19 - i) * d[i - 1] / i;
        }
        for (int i = 0; i <= 18; i++) {
            a[i] = d[i] * Math.pow(Ateam, i) * Math.pow(1 - Ateam, 18 - i);
            b[i] = d[i] * Math.pow(Bteam, i) * Math.pow(1 - Bteam, 18 - i);
        }
        double aSum = 0.0;
        double bSum = 0.0;
        for (int i = 0; i <= 18; i++) {
            if(!isPrime(i)){
                aSum += a[i];
                bSum += b[i];
            }
        }
        
        System.out.println(1- aSum*bSum);

    }
}
