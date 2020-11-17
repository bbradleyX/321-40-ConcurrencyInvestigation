package edu.ithaca.dragon.concurrency.filework;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class FileUtilTest {

    @Test
    public void calcStringOccurrencesTimingTest() {
        // ---------------------------Tests 1-4------------------------------------------------------------------------------
        // final int dataSize = 10;
        System.out.println("----Experiment Modifying Size of Data----");
        System.out.println("Test 1: Data Size 1");
        int dataSize = 1;
        int workload = 1;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 2: Data Size 10");
        dataSize = 10;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 3: Data Size 40");
        dataSize = 40;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 4: Data Size 100");
        dataSize = 100;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);

        // ---------------------------Tests 5-10------------------------------------------------------------------------------
        System.out.println("\n----Experiment Modifying IO Workload----\n #comment out CPU when compiling");
        System.out.println("Test 5: Workload 1");
        dataSize = 10;
        workload = 1;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 6: Workload 0");
        dataSize = 10;
        workload = 0;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 7: Workload 10");
        dataSize = 10;
        workload = 30;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);
        System.out.println("\nTest 8: Workload 30\n");
        dataSize = 10;
        workload = 30;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize, workload);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize, workload);

        System.out.println("\n----Experiment Modifying IO Workload & Size of Data----\n #comment out CPU when compiling");
        System.out.println("Test 9: Workload 1");
        System.out.println("\nTest 10: Workload 0");
        System.out.println("\nTest 11: Workload 10");
        System.out.println("\nTest 12: Workload 30");

        // ---------------------------Tests 13-16------------------------------------------------------------------------------
        System.out.println("\n----Experiment Modifying CPU Workload----\n #comment out IO when compiling");
        System.out.println("Test 13: Workload 1");
        System.out.println("\nTest 14: Workload 0");
        System.out.println("\nTest 15: Workload 10");
        System.out.println("\nTest 16: Workload 30");

        System.out.println("\n----Experiment Modifying Size of Data & CPU Workload----\n #comment out IO when compiling");
        System.out.println("Test 13: Workload 1");
        System.out.println("\nTest 14: Workload 0");
        System.out.println("\nTest 15: Workload 10");
        System.out.println("\nTest 16: Workload 30");

        // ---------------------------Tests 21-24------------------------------------------------------------------------------
        System.out.println("\n----Experiment Modifying Size of Data & Both Workloads----");
        System.out.println("Test 21a: Data Size 10 Workload 1");
        System.out.println("Test 21b: Data Size 10 Workload 0");
        System.out.println("Test 21c: Data Size 10 Workload 10");
        System.out.println("Test 21d: Data Size 10 Workload 30");
        System.out.println("\nTest 22a: Data Size 1 Workload 1");
        System.out.println("\nTest 22b: Data Size 1 Workload 0");
        System.out.println("\nTest 22c: Data Size 1 Workload 10");
        System.out.println("\nTest 22d: Data Size 1 Workload 3");
        System.out.println("\nTest 23a: Data Size 40 Workload 1");
        System.out.println("\nTest 23b: Data Size 40 Workload 0");
        System.out.println("\nTest 23c: Data Size 40 Workload 10");
        System.out.println("\nTest 23d: Data Size 40 Workload 30");
        System.out.println("\nTest 24a: Data Size 100 Workload 1");
        System.out.println("\nTest 24b: Data Size 100 Workload 0");
        System.out.println("\nTest 24c: Data Size 100 Workload 10");
        System.out.println("\nTest 24d: Data Size 100 Workload 30");

    }

    public void calcStringOccurrencesTimingTest(FileUtil utilToTest, int dataSize, int workLoad) {
        ArrayList<String> filenames = new ArrayList<>(dataSize);
        for (int i = 0; i < dataSize; i++) {
            filenames.add("FakeFileName.txt");
        }
        long startTime = System.nanoTime();
        int[] array = utilToTest.calcStringOccurrences(filenames, "keyword", workLoad);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        // System.out.println(Arrays.toString(array));
        System.out.println(utilToTest.getClass().getSimpleName() + " finished in: " + duration);
    }

}
