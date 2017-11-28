package sample;

public class HistoryOfCalculations {
    private Integer value;
    private String inOut;

    public HistoryOfCalculations(Integer value, String inOut) {
        this.value = value;
        this.inOut = inOut;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }
}
