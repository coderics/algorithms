package problems.parallelism;

import java.util.concurrent.Phaser;

/**
 * ## Parallel Programming in Java
 * 4.2 Point-to-Point Synchronization with Phasers
 */
public class PointToPointSynchronization {

    public static void main(String[] args) {
        for (int numRun = 0; numRun < 3; numRun++) {
            System.out.printf("Run %d\n", numRun);
            final Phaser ph0 = new Phaser(1);
            final Phaser ph1 = new Phaser(1);
            final Phaser ph2 = new Phaser(1);

            Thread t0 = new Thread(() -> {
                Computable c = new Computable();
                // Phase 0
                c.doWork(100);
                ph0.arrive();
                ph1.awaitAdvance(0);
                // Phase 1
                c.doWork(300);
            });

            Thread t1 = new Thread(() -> {
                Computable c = new Computable();
                // Phase 0
                c.doWork(200); // A(2)
                ph1.arrive();
                ph0.awaitAdvance(0);
                ph2.awaitAdvance(0);
                // Phase 1
                c.doWork(200); // B(2)
            });

            Thread t2 = new Thread(() -> {
                Computable c = new Computable();
                // Phase 0
                c.doWork(300); // A(3)
                ph2.arrive();
                ph1.awaitAdvance(0);
                // Phase 1
                c.doWork(100); // B(3)
            });

            ///////////////////////////////////////////////////
            /////////////// RUN SEQUENTIAL VERSION ////////////
            ///////////////////////////////////////////////////
            long startTime = System.nanoTime();
            Computable c = new Computable();
            c.doWork(100); // t0 - phase 0
            c.doWork(300); // t0 - phase 1

            c.doWork(200); // t1 - phase 0
            c.doWork(200); // t1 - phase 1

            c.doWork(300); // t2 - phase 0
            c.doWork(100); // t2 - phase 1
            long timeInNanos = System.nanoTime() - startTime;
            System.out.printf(" Sequential version completed in %8.3f seconds\n", timeInNanos / 1e9);

            /////////////////////////////////////////////////
            /////////////// RUN PARALLEL VERSION ////////////
            /////////////////////////////////////////////////
            startTime = System.nanoTime();

            // Start threads
            t0.start();
            t1.start();
            t2.start();
            // Wait for threads to complete
            try {
                t0.join();
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            timeInNanos = System.nanoTime() - startTime;
            System.out.printf(" Parallel version completed in %8.3f seconds\n", timeInNanos / 1e9);
        }
    }

}

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
