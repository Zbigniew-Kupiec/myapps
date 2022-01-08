import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException,
            InstantiationException, IllegalAccessException {
          // uruchamia cały interfejs aplikacji rozbity na poszczególne klasy
        new Frame().setVisible(true);
    }
}
