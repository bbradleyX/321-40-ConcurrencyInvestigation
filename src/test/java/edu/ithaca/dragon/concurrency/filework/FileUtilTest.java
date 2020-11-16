package edu.ithaca.dragon.concurrency.filework;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class FileUtilTest {

    @Test
    public void calcStringOccurrencesTimingTest(){
        final int dataSize = 1000;
        calcStringOccurrencesTimingTest(new SequentialFileUtil(), dataSize);
        calcStringOccurrencesTimingTest(new ThreadedFileUtil(), dataSize);
    }
    
    public void calcStringOccurrencesTimingTest(FileUtil utilToTest, int dataSize){
        ArrayList<String> filenames = new ArrayList<>(dataSize);
        for (int i=0; i<dataSize; i++){
            filenames.add("FakeFileName.txt");
        }
        long startTime = System.nanoTime();
        int[] array = utilToTest.calcStringOccurrences(filenames, "keyword");
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;
        // System.out.println(Arrays.toString(array));
        System.out.println(utilToTest.getClass().getSimpleName() + " finished in: "+duration);   
    }
    
}
