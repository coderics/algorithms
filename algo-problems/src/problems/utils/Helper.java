package problems.utils;

import java.lang.reflect.Array;

import static java.util.Arrays.stream;

public class Helper {


    @SafeVarargs
    private static <T> T[] concatArrays(Class<T> c, T[]... arrays) {
        int resultLength = stream(arrays).mapToInt(a -> a.length).sum();

        @SuppressWarnings("unchecked")
        T[] resultArr = (T[]) Array.newInstance(c, resultLength);

        final int[] resultPos = {0};
        stream(arrays).forEach(srcArr -> {
            System.arraycopy(srcArr, 0, resultArr, resultPos[0], srcArr.length);
            resultPos[0] += srcArr.length;
        });

        return resultArr;
    }
}
