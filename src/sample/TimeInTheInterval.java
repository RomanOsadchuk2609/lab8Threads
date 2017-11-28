package sample;

public class TimeInTheInterval extends Thread{
    private Integer seconds;
    private Boolean isStopped;

    public TimeInTheInterval() {
        seconds =0 ;
        isStopped = true;
    }

    public Integer getSeconds() {
        return seconds;
    }

    @Override
    public void run() {
        while(true){
            if(isInterrupted())break;
            if(!isStopped){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                seconds++;
            }
        }
    }

    public void stopThread() {
        isStopped = true;
    }
    public void startThread() {
        isStopped = false;
    }
}
