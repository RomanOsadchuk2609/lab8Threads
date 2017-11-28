package sample;

import java.util.ArrayList;
import java.util.Random;

public class MyThread extends Thread {
    private Integer delayAsMilliSeconds;
    private Integer counter;
    private Integer difference;
    private Boolean isWorking;
    private Integer sum;
    private Integer lastValueOfCounter;
    private Boolean isPreviousValueWritten;
    private ArrayList<Integer> listOfValues;

    public MyThread(Integer delayAsMilliSeconds, Integer difference) {
        this.delayAsMilliSeconds = delayAsMilliSeconds;
        this.difference = difference;
        this.counter=0;
        isWorking =false;
        sum = 0;
        isPreviousValueWritten = true;
        listOfValues = new ArrayList<>();
        lastValueOfCounter = 0;
    }

    public MyThread(Integer delayAsMilliSeconds) {
        this.delayAsMilliSeconds = delayAsMilliSeconds;
        this.counter=0;
        this.difference = 10;
        isWorking =false;
        sum = 0;
        isPreviousValueWritten = true;
        listOfValues = new ArrayList<>();
        lastValueOfCounter =0;
    }

    public Integer getLastValueOfCounter() {
        return lastValueOfCounter;
    }

    public void setLastValueOfCounter(Integer lastValueOfCounter) {
        this.lastValueOfCounter = lastValueOfCounter;
    }

    public MyThread() {
        this.delayAsMilliSeconds = 100;
        this.counter = 0;
        this.difference = 10;
        isWorking =false;
        sum = 0;
        isPreviousValueWritten = true;
        listOfValues = new ArrayList<>();
        lastValueOfCounter = 0;

    }
    @Override
    public void run() {
        Random random = new Random();
       while (/*isWorking*/true){
           if(isInterrupted())break;
           if(isWorking){
           //if (!isWorking) {interrupt();}
            if (isPreviousValueWritten){
                counter = (random.nextInt(9)+1)*difference;
                listOfValues.add(counter);
                lastValueOfCounter = counter;
                isPreviousValueWritten = false;
            }

           try {
               sleep(delayAsMilliSeconds/*(random.nextInt(9)+1)*/);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

        }
    }}

    public ArrayList<Integer> getListOfValues() {
        return listOfValues;
    }

    public void setListOfValues(ArrayList<Integer> listOfValues) {
        this.listOfValues = listOfValues;
    }

    public Boolean isPreviousValueWritten() {
        return isPreviousValueWritten;
    }

    public void setPreviousValueWritten(Boolean previousValueWritten) {
        isPreviousValueWritten = previousValueWritten;
    }

    public Integer getSum() {
        sum = listOfValues.stream().mapToInt(l -> l.intValue()).sum();
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getDelayAsMilliSeconds() {
        return delayAsMilliSeconds;
    }

    public void setDelayAsMilliSeconds(Integer delayAsMilliSeconds) {
        this.delayAsMilliSeconds = delayAsMilliSeconds;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Integer getDifference() {
        return difference;
    }

    public void setDifference(Integer difference) {
        this.difference = difference;
    }

    public Boolean isWorking() {
        return isWorking;
    }

    public void setWorking(Boolean working) {
        isWorking = working;
    }
}
