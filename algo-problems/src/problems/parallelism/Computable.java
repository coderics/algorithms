package problems.parallelism;


class Computable {
    void doWork(int arg) {
        int N = arg * 1000000;
        int[] arr = new int[N];
        for (int j = 0; j < N; j++) {
            arr[j] = 1/(j+1) + 1/(j+2);
        }
        for (int j = N - 1; j >= 0; j--) {
            arr[j] = 0;
        }
        arr = null;
    }
}
