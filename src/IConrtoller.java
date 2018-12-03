import javax.swing.*;

public interface IConrtoller {
    void onValueUpdate (double value, String operation);
    void setCallBackView (ICallBackView callback);
}
