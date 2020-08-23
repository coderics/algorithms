package problems.parallelism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * PROBLEM: make an array from this three arrays which elements is present in at least two array.
 */
public class ThreeArrays {

    public static void main(String[] args) {
        Integer[] A = {2, 6, 3, 2, 8, 7, 12, 6};
        Integer[] B = {9, 6, 2, 4, 10, 10};
        Integer[] C = {5, 1, 6, 6, 3, 1};

        /* removing duplication for performance impact,
           also HasSet add(), contains() operations have O(1) complexity,
           which we use in the next */
        HashSet<Integer> AA = new HashSet<>(Arrays.asList(A));
        HashSet<Integer> BB = new HashSet<>(Arrays.asList(B));
        HashSet<Integer> CC = new HashSet<>(Arrays.asList(C));

        /* distributing loop cycles between three async tasks */

        Future<List> futureA = CompletableFuture.supplyAsync(() -> {
            List<Integer> list = new ArrayList<>();
            for (Integer a : A) {
                if (BB.contains(a) || CC.contains(a)) list.add(a);
            }
            return list;
        });

        Future<List> futureB = CompletableFuture.supplyAsync(() -> {
            List<Integer> list = new ArrayList<>();
            for (Integer b : B) {
                if (AA.contains(b) || CC.contains(b)) list.add(b);
            }
            return list;
        });

        Future<List> futureC = CompletableFuture.supplyAsync(() -> {
            List<Integer> list = new ArrayList<>();
            for (Integer c : C) {
                if (BB.contains(c) || AA.contains(c)) list.add(c);
            }
            return list;
        });

        try {
            List<Integer> listA = futureA.get();
            List<Integer> listB = futureB.get();
            List<Integer> listC = futureC.get();

            /* joining into one list */
            listA.addAll(listB);
            listA.addAll(listC);
            listA.forEach(el -> System.out.printf("%s ", el));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
