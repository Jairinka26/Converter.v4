public interface IModelEdit extends ISetCallBack {
    void setValue(double value,String operation);

    void updateHistory ();
}
