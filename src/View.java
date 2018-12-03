import javax.swing.*;
import java.util.ArrayList;

public class View extends JPanel implements ICallBackView {
    private IConrtoller controller;
    JTextField result;
    JTextArea historyText;

    View (IConrtoller controller){
        this.controller = controller;
        createPanel();
        controller.setCallBackView(this);
    }

    private void createPanel(){
        setLayout(null);
    //    iControler = new Controler(this);
        JTextField value = new JTextField();
        value.setBounds(10,10,50,30);
        add(value);

        result = new JTextField();
        result.setBounds(10,50,50,30);
        result.setEditable(false);
        add(result);

        JButton grammsVKilogramms = new JButton("G v KG");
        grammsVKilogramms.setBounds(70, 10, 70, 30 );
        add(grammsVKilogramms);
        grammsVKilogramms.addActionListener(e -> controller.onValueUpdate(Double.parseDouble(value.getText()), grammsVKilogramms.getText()));

        JButton button2 = new JButton("KG v T");
        button2.setBounds(150, 10, 70, 30 );
        add(button2);

        historyText=new JTextArea();
        historyText.setBounds(10, 130, 290, 100);
        historyText.setVisible(false);
        add(historyText);

        JButton history = new JButton("History");
        history.setBounds(10, 90, 290, 30 );
        add(history);
        history.addActionListener(e -> {
            if (historyText.isVisible())
                historyText.setVisible(false);
            else
                historyText.setVisible(true);
        });

    }

    @Override
    public void callback(double result, ArrayList<String> history) {
        this.result.setText(Double.toString(result));
        String historyString="";
        for (int i=0; i< history.size();i++) {
            historyString=historyString+history.get(i)+"\n";
            //
        }
        historyText.setText(historyString);


    }
}
