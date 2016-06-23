
package quki.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap {

    public static void main(String[] args) {
        int a[] = new int[] {
                6, 4, 8, 1, 9, 8
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
                if (e1 < e2) {
                    return 1;
                } else if (e1 == e2) {
                    return 0;
                } else {
                    return -1;
                }
            }

        });
        for (int i = 0; i < a.length; i++) {
            pq.add(a[i]);
        }
        System.out.println(pq.peek()); // min value
    }

}
