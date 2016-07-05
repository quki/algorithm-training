
package quki.algorithm.graph.search.perfect;

import java.util.Scanner;

public class BOJ1451 {

    public static int getProduct(int[][] a, int first, int second, int n, int m, int type) {
        int sumFirst = 0;
        int sumSecond = 0;
        int sumThird = 0;
        if (type == 0) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= first; j++) {
                    sumFirst += a[i][j];
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = first + 1; j <= second; j++) {
                    sumSecond += a[i][j];
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = second + 1; j <= m; j++) {
                    sumThird += a[i][j];
                }
            }
        } else if (type == 1) {
            for (int i = 1; i <= first; i++) {
                for (int j = 1; j <= m; j++) {
                    sumFirst += a[i][j];
                }
            }
            for (int i = first + 1; i <= second; i++) {
                for (int j = 1; j <= m; j++) {
                    sumSecond += a[i][j];
                }
            }
            for (int i = second + 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    sumThird += a[i][j];
                }
            }
        }

        return sumFirst * sumSecond * sumThird;
    }

    public static int getProduct(int[][] a, int vertical, int horizontal, int n, int m, int type1,
            int type2) {
        int sumFirst = 0;
        int sumSecond = 0;
        int sumThird = 0;
        if (type1 == 2) {
            if (type2 == 0) {
                for (int i = 1; i <= horizontal; i++) {
                    for (int j = 1; j <= vertical; j++) {
                        sumFirst += a[i][j];
                    }
                }
                for (int i = horizontal + 1; i <= n; i++) {
                    for (int j = 1; j <= vertical; j++) {
                        sumSecond += a[i][j];
                    }
                }
                for (int i = 1; i <= n; i++) {
                    for (int j = vertical + 1; j <= m; j++) {
                        sumThird += a[i][j];
                    }
                }
            } else {
                for (int i = 1; i <= horizontal; i++) {
                    for (int j = m; j >= vertical; j--) {
                        sumFirst += a[i][j];
                    }
                }
                for (int i = horizontal + 1; i <= n; i++) {
                    for (int j = m; j >= vertical; j--) {
                        sumSecond += a[i][j];
                    }
                }
                for (int i = 1; i <= n; i++) {
                    for (int j = vertical - 1; j >= 1; j--) {
                        sumThird += a[i][j];
                    }
                }
            }

        } else if (type1 == 3) {
/////////////////////////////////////////////
        }

        return sumFirst * sumSecond * sumThird;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int a[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String line = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt("" + line.charAt(j - 1));
            }
        }
        int ans = 0;
        // m을 3등분 column 3개 type: 0
        for (int first = 1; first <= m - 2; first++) {
            for (int second = first + 1; second <= m - 1; second++) {
                ans = Math.max(ans, getProduct(a, first, second, n, m, 0));
            }
        }
        // n을 3등분 row 3개 type: 1
        for (int first = 1; first <= n - 2; first++) {
            for (int second = first + 1; second <= n - 1; second++) {
                ans = Math.max(ans, getProduct(a, first, second, n, m, 1));
            }
        }

        // m을 2등분 column 2개, row 1개 type: 2,0
        for (int vertical = 1; vertical <= m - 1; vertical++) {
            for (int horizontal = 1; horizontal <= n - 1; horizontal++) {
                ans = Math.max(ans, getProduct(a, vertical, horizontal, n, m, 2, 0));
            }
        }
        // m을 2등분 column 2개, row 1개 type: 2,1
        for (int vertical = n; vertical >= 2; vertical--) {
            for (int horizontal = 1; horizontal <= n - 1; horizontal++) {
                ans = Math.max(ans, getProduct(a, vertical, horizontal, n, m, 2, 1));
            }
        }
     // n을 2등분 column 2개, row 1개 type: 3,0
        for (int vertical = n; vertical >= 2; vertical--) {
            for (int horizontal = 1; horizontal <= n - 1; horizontal++) {
                ans = Math.max(ans, getProduct(a, vertical, horizontal, n, m, 3, 1));
            }
        }
     // m을 2등분 column 2개, row 1개 type: 3,1
        for (int vertical = n; vertical >= 2; vertical--) {
            for (int horizontal = 1; horizontal <= n - 1; horizontal++) {
                ans = Math.max(ans, getProduct(a, vertical, horizontal, n, m, 3, 1));
            }
        }

        System.out.println(ans);

    }

}
