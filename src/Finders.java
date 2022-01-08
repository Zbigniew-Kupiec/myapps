import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Finders extends JDialog {
        public Finders() {
            this.setTitle("Znajdź");
            this.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\find.png"));
            this.add(buttonSearch, BorderLayout.EAST);
            this.add(searchers, BorderLayout.CENTER);
            this.add(text, BorderLayout.WEST);
            text.setBorder(BorderFactory.createCompoundBorder(null, eBorder));
            int myWeight = Toolkit.getDefaultToolkit().getScreenSize().width;
            int myHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
            this.setSize(350, 70);
            this.getContentPane().setBackground(Color.DARK_GRAY);
            text.setForeground(Color.WHITE);
            this.setResizable(false);
            int widthFrame = this.getSize().width;
            int heightFrame = this.getSize().height;
            this.setLocation((myWeight - widthFrame)/3, (myHeight - heightFrame)/3);
            buttonSearch.addActionListener(new searchText());
            this.setAlwaysOnTop(true);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        }
        public class searchText implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAlwaysOnTop(true);
                startSearch = Frame.textArea.getText().toLowerCase().indexOf(searchers.getText().toLowerCase(),
                        startSearch + searchers.getText().toLowerCase().length());
                if(startSearch == -1)
                    startSearch = Frame.textArea.getText().toLowerCase().indexOf(searchers.getText().toLowerCase());
                if(startSearch >= 0 && searchers.getText().toLowerCase().length() > 0) {
                    Frame.textArea.requestFocus();
                    Frame.textArea.select(startSearch, startSearch + searchers.getText().toLowerCase().length());
                }
            }
        }

        public static int startSearch = -1;
        final JLabel text = new JLabel("Wpisz Tekst");
        final EmptyBorder eBorder = new EmptyBorder(2, 10, 2, 10);
        final JButton buttonSearch = new JButton("Znajdź");
        public final JTextField searchers = new JTextField(15);
}