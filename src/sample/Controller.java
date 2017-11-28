package sample;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.TouchEvent;

public class Controller {

    @FXML
    private Button btnStartThread1;

    @FXML
    private Label lbl1;

    @FXML
    private Button btnStartThread3;

    @FXML
    private Label lbl3;

    @FXML
    private Button btnStartThread2;

    @FXML
    private Label lbl2;

    @FXML
    private Button btnStartAll;

    @FXML
    private Button btnStop;

    @FXML
    private Button btnStopThread1;

    @FXML
    private Button btnStopThread2;

    @FXML
    private Button btnStopThread3;

    @FXML
    private Slider slider1;

    @FXML
    private Slider slider2;

    @FXML
    private Slider slider3;

    private ObservableList<String> listOfIncomeOutcomeValues
            = FXCollections.observableArrayList();

    @FXML
    private ListView<String> listInfo;

    @FXML
    private Label lblSum;

    private MyCalculations calculations = new MyCalculations();

    private AnimationTimer at = new AnimationTimer() {
        long lastUpdate = 0;
        @Override
        public void handle(long now) {
            if(now-lastUpdate>=1_000_000){
                calculations.setDelayOfThread1((int)slider1.getValue());
                calculations.setDelayOfThread2((int)slider2.getValue());
                calculations.setDelayOfThread3((int)slider3.getValue());
                setTextInLabels();
                calculations.writeValuesToTheSum();
                lblSum.setText(calculations.getSum()+"");
                listInfo.setItems(calculations.getHistory());

            }

            lastUpdate = now;
        }
    };

    @FXML
    void initialize() {
        at.start();
    }

    @FXML
    void OnClickBtnStartThread1(ActionEvent event) {
        calculations.startThread1();
    }

    @FXML
    void OnClickBtnStartThread2(ActionEvent event) {
        calculations.startThread2();
    }

    @FXML
    void OnClickBtnStartThread3(ActionEvent event) {
        calculations.startThread3();
    }
    private void setTextInLabels(){
        if (calculations.isThread1Working())
            lbl1.setText(calculations.getCounterOfThread1()+"");

        if (calculations.isThread2Working())
            lbl2.setText(calculations.getCounterOfThread2()+"");

        if (calculations.isThread3Working())
            lbl3.setText(calculations.getCounterOfThread3()+"");
    }

    @FXML
    void OnClickBtnStartAll(ActionEvent event) {
        OnClickBtnStartThread1(event);
        OnClickBtnStartThread2(event);
        OnClickBtnStartThread3(event);
    }

    @FXML
    void OnClickBtnStopThread1(ActionEvent event) {
        calculations.stopThread1();
    }

    @FXML
    void OnClickBtnStopThread2(ActionEvent event) {
        calculations.stopThread2();
    }

    @FXML
    void OnClickBtnStopThread3(ActionEvent event) {
        calculations.stopThread3();
    }

    @FXML
    void OnClickBtnStop(ActionEvent event) {
        OnClickBtnStopThread1(event);
        OnClickBtnStopThread2(event);
        OnClickBtnStopThread3(event);
    }


};




