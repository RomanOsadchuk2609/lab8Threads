package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MyCalculations {

    private MyThread thread1 = new MyThread(200,1);
    private MyThread thread2 = new MyThread(800,10);
    private MyThread thread3 = new MyThread(3000,100);
    private Integer sum;
    private ArrayList<Integer> listOfValues;
    private ObservableList<String> history;

    private TimeInTheInterval timeInTheInterval = new TimeInTheInterval();

    public MyCalculations() {
        sum = 0;
        listOfValues = new ArrayList<>();
        history = FXCollections.observableArrayList();
        thread1.start();
        thread2.start();
        thread3.start();
        timeInTheInterval.start();
    }

    //****************************************************************************
    //start threads methods
    //****************************************************************************
    public void startThread1(){
        thread1.setWorking(true);
    }

    public void startThread2(){
        thread2.setWorking(true);
    }

    public void startThread3(){
        thread3.setWorking(true);
    }

    public Integer getSum() {
        sum = listOfValues.stream().mapToInt(l -> l.intValue()).sum();
        return sum;
    }

    public void writeValuesToTheSum(){
        Integer lastValue1 = thread1.getLastValueOfCounter();
        Integer lastValue2 = thread2.getLastValueOfCounter();
        Integer lastValue3 = thread3.getLastValueOfCounter();
        Integer sumOut1=0;
        Integer sumOut2=0;
        Integer sumOut3=0;

        //*********************************************************************
        //Thread 3
        //*********************************************************************
        if(lastValue3!=0){
            if (this.getSum()+lastValue3<=19500){
                Date date = new Date();
                SimpleDateFormat myDate = new SimpleDateFormat(" dd.MM.yyyy HH:mm:ss");
                history.add(lastValue3+" in "+myDate.format(date));
                listOfValues.add(lastValue3);
                thread3.setLastValueOfCounter(0);
                thread3.setPreviousValueWritten(true);
            }
            else{
                int i=0;
                while(i<listOfValues.size()){
                    if (this.getSum()-(sumOut3+listOfValues.get(i))>=18500){
                        sumOut3+=listOfValues.get(i);
                        Date date = new Date();
                        SimpleDateFormat myDate = new SimpleDateFormat(" dd.MM.yyyy HH:mm:ss");
                        history.add(listOfValues.get(i)+" out "+myDate.format(date));
                        listOfValues.remove(i);
                    }
                    else i++;
                }

                if (sumOut3>=lastValue3){
                    Date date = new Date();
                    SimpleDateFormat myDate = new SimpleDateFormat(" dd.MM.yyyy HH:mm:ss");
                    history.add(lastValue3+" in "+myDate.format(date));
                    listOfValues.add(lastValue3);
                    thread3.setLastValueOfCounter(0);
                    thread3.setPreviousValueWritten(true);
                }
            }
        }

        //*********************************************************************
        //Thread 2
        //*********************************************************************
        if (lastValue2!=0){
            if (this.getSum()+lastValue2<=19500){
                Date date = new Date();
                SimpleDateFormat myDate = new SimpleDateFormat(" dd.MM.yyyy HH:mm:ss");
                history.add(lastValue2+" in "+myDate.format(date));
                listOfValues.add(lastValue2);
                thread2.setLastValueOfCounter(0);
                thread2.setPreviousValueWritten(true);
            }
            else{
                int i=0;
                while(i<listOfValues.size()){
                    if (this.getSum()-(sumOut2+listOfValues.get(i))>=18500){
                        sumOut2+=listOfValues.get(i);
                        Date date = new Date();
                        SimpleDateFormat myDate = new SimpleDateFormat(" dd.MM.yyyy HH:mm:ss");
                        history.add(listOfValues.get(i)+" out "+myDate.format(date));
                        listOfValues.remove(i);
                    }
                    else i++;
                }
                if (this.getSum()+lastValue2<=19500){
                    Date date = new Date();
                    SimpleDateFormat myDate = new SimpleDateFormat(" dd.MM.yyyy HH:mm:ss");
                    history.add(lastValue2+" in "+myDate.format(date));
                    listOfValues.add(lastValue2);
                    thread2.setLastValueOfCounter(0);
                    thread2.setPreviousValueWritten(true);
                }
            }
        }

        //*********************************************************************
        //Thread 2
        //*********************************************************************
        if (lastValue1!=0){
            if (this.getSum()+lastValue1 <= 19500){
                Date date = new Date();
                SimpleDateFormat myDate = new SimpleDateFormat(" dd.MM.yyyy HH:mm:ss");
                history.add(lastValue1+" in "+myDate.format(date));
                listOfValues.add(lastValue1);
                thread1.setLastValueOfCounter(0);
                thread1.setPreviousValueWritten(true);
            }
            else{
                int i=0;
                while(i<listOfValues.size()){
                    if (this.getSum()-(sumOut1+listOfValues.get(i))>=18500){
                        sumOut1+=listOfValues.get(i);
                        Date date = new Date();
                        SimpleDateFormat myDate = new SimpleDateFormat(" dd.MM.yyyy HH:mm:ss");
                        history.add(listOfValues.get(i)+" out "+myDate.format(date));
                        listOfValues.remove(i);
                    }
                    else i++;
                }
                if (this.getSum()+lastValue1<=19500){
                    Date date = new Date();
                    SimpleDateFormat myDate = new SimpleDateFormat(" dd.MM.yyyy HH:mm:ss");
                    history.add(lastValue1+" in "+myDate.format(date));
                    listOfValues.add(lastValue1);
                    thread1.setLastValueOfCounter(0);
                    thread1.setPreviousValueWritten(true);
                }
            }
        }

    }

    public ObservableList<String> getHistory(){
        return history;
    }

    //****************************************************************************
    //stop threads methods
    //****************************************************************************
    public void stopThread1(){
        thread1.setWorking(false);
    }

    public void stopThread2(){
        thread2.setWorking(false);
    }

    public void stopThread3(){
        thread3.setWorking(false);
    }

    //****************************************************************************
    //get counter of threads methods
    //****************************************************************************
    public Integer getCounterOfThread1(){
        return thread1.getCounter();
    }

    public Integer getCounterOfThread2(){
        return thread2.getCounter();
    }

    public Integer getCounterOfThread3(){
        return thread3.getCounter();
    }

    //****************************************************************************
    //is threads working methods
    //****************************************************************************
    public Boolean isThread1Working(){
        return thread1.isWorking();
    }

    public Boolean isThread2Working(){
        return thread2.isWorking();
    }
    public Boolean isThread3Working(){
        return thread3.isWorking();
    }
    //****************************************************************************
    //set delay of threads methods
    //****************************************************************************
    public void setDelayOfThread1(Integer delayAsMilliSeconds){
        thread1.setDelayAsMilliSeconds(delayAsMilliSeconds);
    }

    public void setDelayOfThread2(Integer delayAsMilliSeconds){
        thread2.setDelayAsMilliSeconds(delayAsMilliSeconds);
    }

    public void setDelayOfThread3(Integer delayAsMilliSeconds){
        thread3.setDelayAsMilliSeconds(delayAsMilliSeconds);
    }
}
