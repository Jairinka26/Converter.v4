import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        init();
    }

    static void init(){
        IModelEdit model = new Model();
        IConrtoller controller = new Controller(model);
        View view = new View(controller);

        JFrame frame = new JFrame("Test");
        frame.setSize(400, 400);
        frame.add(view);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //frame.pack();
        frame.setVisible(true);

       // controller.onValueUpdate(34);

    }
}
