package problems.parallelism;

import java.util.concurrent.Phaser;

/**
 * ## Parallel Programming in Java
 * 4.4 Pipeline Parallelism
 */
public class PipelineParallelism {

    public static void main(String[] args) {
        final int imagesNum = 100; // Number of images to process

        for (int numRun = 0; numRun < 3; numRun++) {
            System.out.printf("Run %d\n", numRun);
            final Phaser ph0 = new Phaser(1);
            final Phaser ph1 = new Phaser(1);

            Thread t0 = new Thread(() -> { // DENOISE stage
                Computable c = new Computable();
                for (int i = 0; i < imagesNum; i++) {
                    c.doWork(10);
                    ph0.arrive();
                }
            });

            Thread t1 = new Thread(() -> { // REGISTER stage
                Computable c = new Computable();
                for (int i = 0; i < imagesNum; i++) {
                    ph0.awaitAdvance(i);
                    c.doWork(10);
                    ph1.arrive();
                }
            });

            Thread t2 = new Thread(() -> { // SEGMENT stage
                Computable c = new Computable();
                for (int i = 0; i < imagesNum; i++) {
                    ph1.awaitAdvance(i);
                    c.doWork(10);
                }
            });

            ///////////////////////////////////////////////////
            /////////////// RUN SEQUENTIAL VERSION ////////////
            ///////////////////////////////////////////////////
            long startTime = System.nanoTime();
            Computable c = new Computable();
            for (int i = 0; i < imagesNum; i++) {
                c.doWork(10); // DENOISE stage
                c.doWork(10); // REGISTER stage
                c.doWork(10); // SEGMENT stage
            }


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
