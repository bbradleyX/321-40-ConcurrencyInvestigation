package edu.ithaca.dragon.concurrency.filework;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class FileUtilTest {

    @Test
    public void calcStringOccurrencesTimingTest() {
        // final int dataSize = 50;
        // ---------------------------Tests 1-4------------------------------------------------------------------------------
        System.out.println("----Experiment Modifying Size of Data----");
        System.out.println("Test 1: Data Size 1");
        int dataSize = 1;
        int workload = 1;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 2: Data Size 50");
        dataSize = 50;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 3: Data Size 500");
        dataSize = 500;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 4: Data Size 5000");
        dataSize = 5000;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);

        // ---------------------------Tests 5-12------------------------------------------------------------------------------
        System.out.println("\n----Experiment Modifying IO Workload----\t #comment out CPU when compiling");
        System.out.println("Test 5: Workload 1");
        dataSize = 50;
        workload = 1;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 6: Workload 0");
        dataSize = 50;
        workload = 0;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 7: Workload 50");
        dataSize = 50;
        workload = 30;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 8: Workload 30\n");
        dataSize = 50;
        workload = 30;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);

        
        // ---------------------------Tests 13-20------------------------------------------------------------------------------
        System.out.println("\n----Experiment Modifying CPU Workload----\t #comment out IO when compiling");
        System.out.println("Test 13: Workload 1");
        dataSize = 50;
        workload = 1;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 14: Workload 0");
        dataSize = 50;
        workload = 0;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 15: Workload 50");
        dataSize = 50;
        workload = 50;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 16: Workload 30");
        dataSize = 50;
        workload = 30;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);

        // ---------------------------Tests 21-24------------------------------------------------------------------------------
        System.out.println("\n----Experiment Modifying Size of Data & Both Workloads----");
        System.out.println("\nTest 21a: Data Size 50 Workload 1");
        dataSize = 50;
        workload = 1;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 21b: Data Size 50 Workload 0");
        dataSize = 50;
        workload = 0;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 21c: Data Size 50 Workload 50");
        dataSize = 50;
        workload = 50;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 21d: Data Size 50 Workload 30");
        dataSize = 50;
        workload = 30;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 22a: Data Size 1 Workload 1");
        dataSize = 1;
        workload = 1;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 22b: Data Size 1 Workload 0");
        dataSize = 1;
        workload = 0;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 22c: Data Size 1 Workload 50");
        dataSize = 1;
        workload = 50;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 22d: Data Size 1 Workload 30");
        dataSize = 1;
        workload = 30;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 23a: Data Size 500 Workload 1");
        dataSize = 500;
        workload = 1;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 23b: Data Size 500 Workload 0");
        dataSize = 500;
        workload = 0;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 23c: Data Size 500 Workload 50");
        dataSize = 500;
        workload = 50;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 23d: Data Size 500 Workload 30");
        dataSize = 500;
        workload = 30;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 24a: Data Size 5000 Workload 1");
        dataSize = 5000;
        workload = 1;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 24b: Data Size 5000 Workload 0");
        dataSize = 5000;
        workload = 0;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 24c: Data Size 5000 Workload 50");
        dataSize = 5000;
        workload = 50;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 24d: Data Size 5000 Workload 30");
        dataSize = 5000;
        workload = 30;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);

    }

    public void calcStringOccurrencesTimingTest(FileUtil utilToTest, int dataSize, int workLoad) {
        ArrayList<String> filenames = new ArrayList<>(dataSize);
        for (int i = 0; i < dataSize; i++) {
            filenames.add("FakeFileName.txt");
        }
        long startTime = System.nanoTime();
        int[] array = utilToTest.calcStringOccurrences(filenames, "keyword", workLoad);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 50000000;
        // System.out.println(Arrays.toString(array));
        System.out.println(utilToTest.getClass().getSimpleName() + " finished in: " + duration);
    }

}
