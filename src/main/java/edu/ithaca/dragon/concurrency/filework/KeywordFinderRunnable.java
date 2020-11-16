package edu.ithaca.dragon.concurrency.filework;

import java.util.Random;

public class KeywordFinderRunnable implements Runnable {
    int[] array;
    int index;
    String filename;
    int amountOfPretendWork;

    public KeywordFinderRunnable(int[] array, int index, String filename) {
        this.array = array;
        this.index = index;
        this.filename = filename;
        this.amountOfPretendWork = 1;
    }

    public void run() {
        readDocument(amountOfPretendWork);
        processDocument(amountOfPretendWork);
        array[index] = new Random().nextInt(1000);
    }

    private void readDocument(int amount) {
        try {
            //fake IO work
            Thread.sleep(amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void processDocument(int amount){
        //fake CPU work
        double x = 1000000;
		for (int y=0; y<amount*1000; y++){
			x/=2;
		}
    }

    



    
}
