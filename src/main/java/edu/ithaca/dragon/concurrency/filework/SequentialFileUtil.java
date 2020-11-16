package edu.ithaca.dragon.concurrency.filework;

import java.util.ArrayList;

public class SequentialFileUtil implements FileUtil {

    @Override
    public int[] calcStringOccurrences(ArrayList<String> filenames, String stringToFind) {
        int[] counts = new int[filenames.size()];
        for (int i=0; i<filenames.size(); i++){
            new KeywordFinderRunnable(counts, i, filenames.get(i)).run();
        }
        return counts;
    }
    
}
