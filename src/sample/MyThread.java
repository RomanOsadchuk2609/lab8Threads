package sample;

import java.util.ArrayList;
import java.util.Random;

public class MyThread extends Thread {
    private Integer delayAsMilliSeconds;
    private Integer counter;
    private Integer difference;
    private Boolean isWorking;
    private Integer lastValueOfCounter;
    private Boolean isPreviousValueWritten;

    public MyThread(Integer delayAsMilliSeconds, Integer difference) {
        this.delayAsMilliSeconds = delayAsMilliSeconds;
        this.difference = difference;
        this.counter=0;
        isWorking =false;
        isPreviousValueWritten = true;
        lastValueOfCounter = 0;
    }


    public Integer getLastValueOfCounter() {
        return lastValueOfCounter;
    }

    public void setLastValueOfCounter(Integer lastValueOfCounter) {
        this.lastValueOfCounter = lastValueOfCounter;
    }

    @Override
    public void run() {
        Random random = new Random();
       while (true){
           if(isInterrupted())break;
               if(isWorking){
                if (isPreviousValueWritten){
                    counter = (random.nextInt(9)+1)*difference;
                    lastValueOfCounter = counter;
                    isPreviousValueWritten = false;
                }

               try {
                   sleep(delayAsMilliSeconds/*(random.nextInt(9)+1)*/);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

            }
        }
    }

    public Boolean isPreviousValueWritten() {
        return isPreviousValueWritten;
    }

    public void setPreviousValueWritten(Boolean previousValueWritten) {
        isPreviousValueWritten = previousValueWritten;
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
