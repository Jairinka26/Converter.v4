import javax.swing.*;
import java.util.ArrayList;

public class Controller implements IOnResultUpdate,IConrtoller {
    private IModelEdit editModel;
    private IOnResultUpdate callBack;
    private ICallBackView callBackView;

    Controller(IModelEdit model){
        editModel = model;
        editModel.setCallBack(this);
       // this.callBack= callBack;
    }
    @Override
    public void onValueUpdate (double value, String operation){
        editModel.setValue(value,operation);
    }

    @Override
    public void onResultUpdate(double result, ArrayList<String> history){
     //   System.out.println(Double.toString(result));
        callBackView.callback(result,history);
     //   editModel.updateHistory();
    }

//    void setCallBack(IModelEdit model){
//        this.model = model;
//    }

    public void setCallBackView(ICallBackView callBack){
        callBackView = callBack;
    }
}
