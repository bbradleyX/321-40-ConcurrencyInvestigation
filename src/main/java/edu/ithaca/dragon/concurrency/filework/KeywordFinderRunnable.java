package edu.ithaca.dragon.concurrency.filework;

import java.util.Random;

public class KeywordFinderRunnable implements Runnable {
    int[] array;
    int index;
    String filename;
    int amountOfPretendWork;
    /* boolean testingForBoth;
    String workType1;
    String workType2; */

    /**public KeywordFinderRunnable(int[] array, int index, String filename) {
        this.array = array;
        this.index = index;
        this.filename = filename;
        this.amountOfPretendWork = 1;
    }**/
    public KeywordFinderRunnable(int[] array, int index, String filename, int amountOfPretendWork) {
        this.array = array;
        this.index = index;
        this.filename = filename;
        this.amountOfPretendWork = amountOfPretendWork;
    }

    public void run() {
        //readDocument(amountOfPretendWork);
        processDocument(amountOfPretendWork);
        array[index] = new Random().nextInt(1000);
    }

    /* private void readDocument(int amount) {
        try {
            //fake IO work
            //this.workType1 = "IO";
            Thread.sleep(amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } */

     private void processDocument(int amount){
        //fake CPU work
        //this.workType1 = "CPU";
        double x = 1000000;
		for (int y=0; y<amount*1000; y++){
			x/=2;
		}
    } 

    /* private void workType(){
        if(this.workType2 == "both"){
            this.testingForBoth = true;
            System.out.println(testingForBoth);
        }
        else if (this.workType1 == "CPU"){
            this.testingForBoth = false;
            System.out.println(testingForBoth);
        }
        else if (this.workType1 == "IO"){
            this.testingForBoth = false;
            System.out.println(testingForBoth);
        }
        else{
            this.testingForBoth = false;
            System.out.println(testingForBoth);
        }

    } */

    



    
}
