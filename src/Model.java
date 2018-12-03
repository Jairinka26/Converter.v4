import java.util.ArrayList;

public class Model implements IModelEdit {
    private double value;
    private double result;
    private String operation;
    private IOnResultUpdate callBack;
    ArrayList<String> historyList = new ArrayList<>();
    private int indexHistory;

    ///////////////////////////////////////////////
    ///  Getters and setters
    ///////////////////////////////////////////////

    @Override
    public void setValue(double value,String operation) {
        if (this.value != 0.0) {
            updateHistory();
        }
        this.value = value;
        this.operation = operation;
        calculateResult(value,operation);
       // historyList.add(indexHistory, value+operation);
    }

//    public double getValue() {
//        return value;
//    }

    public void setResult(double result) {
        this.result = result;
        callBack.onResultUpdate(result,historyList);
    }

    public double getResult() {
        return result;
    }

    public ArrayList<String> getHistory(){
        return historyList;
    }

    ////////////////////////////////////////////////

    void calculateResult(double value, String operation){
        switch (operation){
            case "G v KG":
                result = value/100;
                break;
        }
        setResult(result);
    }

    ///////////////////////////////////////////////

    public void updateHistory (){
        historyList.add(value + " " +  operation + " " + result);
    }

    public void setCallBack(IOnResultUpdate callBack){
        this.callBack = callBack;
    }
}
