
package quki.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Object sort using Comparator interface
 * (Ascending)
 * @author quki
 *
 */
public class ObjectSort {

    public static class Point {
        int x;

        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> al = new ArrayList<>();
        while (n-- > 0) {
            al.add(new Point(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(al, new Comparator<Point>() {

            @Override
            public int compare(Point p1, Point p2) {
                if (p1.x < p2.x) {
                    return -1;
                } else if (p1.x == p2.x) {
                    if(p1.y < p2.y){
                        return -1;
                    }else if(p1.y == p2.y){
                        return 0;
                    }else{
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        });

        for (Point e: al) {
            System.out.println("x: "+e.x+" y: "+e.y);
        }

    }

}
