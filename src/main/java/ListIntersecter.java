import javafx.application.Platform;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ListIntersecter implements Runnable  {
    private final Thread t;

    private final List<Integer> a;
    private final List<Integer> b;
    private int sizeA,sizeB;

    private Random ran = new Random();

    private Set<Integer> resultSet;


    public ListIntersecter(int sizeA, int sizeB){
        t = new Thread(this);
        this.sizeA = sizeA;
        this.sizeB = sizeB;





        a = new LinkedList<>();
        b = new LinkedList<>();

        //populate Lists
        for (int i = 0; i < sizeA; i++) {
            a.add(ran.nextInt());
        }

        for (int j = 0; j < sizeB; j++) {
            b.add(ran.nextInt());
        }

        //we do want to keep the thread going after closing UI
        t.setDaemon(true);
        t.start();

    }

    @Override
    public void run(){

        //by default left should be selected / then a should be put into the hashSet;
        boolean left = ViewContainer.getView().getRb1().isSelected();

        //change view, reset
        Platform.runLater(()->{
            ViewContainer.getView().getTimeLbl().setText("XX");
            ViewContainer.getView().getIntersectionLbl().setText("XX");
        });

        long startTime = System.nanoTime();


        resultSet = Intersecter.intersectLists(a,b,left);


        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        long timeElapsedInMilliSec = TimeUnit.MILLISECONDS.convert(timeElapsed, TimeUnit.NANOSECONDS);

        //change view, set
        Platform.runLater(()->{
            ViewContainer.getView().getTimeLbl().setText(String.valueOf(timeElapsedInMilliSec));
            ViewContainer.getView().getIntersectionLbl().setText(String.valueOf(resultSet.size()));
            ViewContainer.getView().getRunBtn().setDisable(false);
        });

    }




}
