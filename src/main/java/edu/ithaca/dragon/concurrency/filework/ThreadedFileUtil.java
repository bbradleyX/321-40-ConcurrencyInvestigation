package edu.ithaca.dragon.concurrency.filework;

import java.util.ArrayList;
import java.util.List;

public class ThreadedFileUtil implements FileUtil {

    @Override
    public int[] calcStringOccurrences(ArrayList<String> filenames, String stringToFind) {
        int[] counts = new int[filenames.size()];
        List<Thread> workerThreads = new ArrayList<Thread>(filenames.size());
        for (int i = 0; i < filenames.size(); i++) {
            Thread newThread = new Thread(new KeywordFinderRunnable(counts, i, filenames.get(i)));
            newThread.start();
            workerThreads.add(newThread);
        }

        for (Thread workerThread : workerThreads) {
            try {
                workerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return counts;
    }
}
