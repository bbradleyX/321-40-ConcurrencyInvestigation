import java.util.Random;
import java.util.concurrent.Callable;

public class KeywordFinderCallable implements Callable<Integer> {
    String filename;
    int amountOfPretendWork;

    public KeywordFinderCallable(String filename) {
        this.filename = filename;
        this.amountOfPretendWork = 1;
    }

    @Override
    public Integer call() throws Exception {
        processDocument(amountOfPretendWork);
        return new Random().nextInt(1000);
    }

    private void processDocument(int amount){
        //fake CPU work
        //this.workType1 = "CPU";
        double x = 1000000;
		for (int y=0; y<amount*1000; y++){
			x/=2;
		}
    }



}