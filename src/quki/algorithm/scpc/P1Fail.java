
package quki.algorithm.scpc;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 2의 63승 은 8byte를 넘어가므로, C에서는 unsigned long long을 써야함.(Java에서는 BigInteger)
 * TC 20개까지 맞고 이후는 시간초과남.
 * @author quki
 *
 */
public class P1Fail {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        int T;
        int test_case;

        T = sc.nextInt();
        for (test_case = 1; test_case <= T; test_case++) {
            int k = sc.nextInt();

            Queue<BigInteger> q = new LinkedList<>();
            q.add(BigInteger.ONE);
            BigInteger max = BigInteger.ZERO;
            BigInteger min = new BigInteger("1000000000");
            for (int i = 0; i <= k; i++) {
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    if (i != k) {
                        BigInteger x = q.poll();
                        q.add(x.multiply(new BigInteger("2")));
                        BigInteger newX = x.subtract(BigInteger.ONE).divide(new BigInteger("3"));// (x-1)/3
                        BigInteger remainder = x.subtract(BigInteger.ONE).remainder(new BigInteger("3")); // (x-1)%3
                        
                        // 나머지가 0, 다음항이 1이 아니며, 다음항이 짝수가 아닌경우
                        if (remainder.equals(BigInteger.ZERO) && !newX.equals(BigInteger.ONE)
                                && !newX.remainder(new BigInteger("2")).equals(BigInteger.ZERO)) {
                            q.add(newX);
                        }
                    } else {
                        // 마지막항
                        BigInteger x = q.poll();
                        max = max.max(x);
                        min = min.min(x);
                    }
                }
            }
            // 이 부분에서 정답을 출력하십시오.
            System.out.println("Case #" + test_case);
            System.out.println(min + " " + max);
        }
    }

}
