import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class FontChooser extends JComponent {


    /**
     * Wyświetla okno dialogowe z określonym i nadrzędnym tytułem.
     */
    public static Font showDialog(Component parent, String title)
    {
        final FontChooser pane = new FontChooser();

        FontTracker ok = new FontTracker(pane);

        JDialog dialog = createDialog(parent, title, true, pane, ok, null);
        dialog.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\font_file.png"));
        dialog.addWindowListener(new FontChooserDialog.Closer());
        dialog.addComponentListener(new FontChooserDialog.DisposeOnClose());

        dialog.setVisible(true);
        // Blokuje, dopóki użytkownik nie zamknie okna dialogowego

        return ok.getSelectedFont();
    }

    /**
     * Tworzy i zwraca nowe okno dialogowe zawierające
     * określony panel FontChooser wraz z „OK” i „Anuluj”.
     * Jeśli zostanie naciśnięty jeden z przycisków „OK” lub „Anuluj”,
     * okno dialogowe jest automatycznie ukrywane (ale nie usuwane).
     */
    public static JDialog createDialog(
            Component parent, String title,
            boolean modal,
            FontChooser chooserPane,
            ActionListener okListener,
            ActionListener cancelListener)
    {
        return new FontChooserDialog(
                parent, title, modal, chooserPane,
                okListener, cancelListener);
    }


    /**
     * Konstruktor: Tworzy panel wyboru czcionek,
     * który składa się z okienka wejściowego z trzema
     * Listami dla nazwy czcionki, stylu i rozmiaru.
     */
    public FontChooser() {
        setLayout(new BorderLayout());

        PreviewPanel previewPane = new PreviewPanel();
        m_inputPane = new InputPanel(previewPane);
        // ListSelectionListener
        add(m_inputPane, BorderLayout.CENTER);
        add(previewPane, BorderLayout.SOUTH);
    }

    /**
     * Zwraca bieżącą czcionkę z selektora czcionek.
     * (Przekazuje pracę do metody funkcji getFont() panelu wejściowego.)
     */
    public Font getSelectedFont()
    {
        return m_inputPane.getSelectedFont();
    }

    private final InputPanel m_inputPane;

    /**
     * Klasa prezentująca użytkownikowi zestaw
     * trzech list, po jednej dla nazwy czcionki, stylu i rozmiaru.
     */
    static class InputPanel extends JPanel {
        /**
         * Konstruktor: Tworzy instancję InputPanel.
         *
         * @param listener słuchacz wyboru listy, który
         * będzie słuchać zmian w stanie list.
         */
        public InputPanel(ListSelectionListener listener) {
            // Nazwa Czcionki
            setLayout(new BorderLayout());
            Box nameBox = Box.createVerticalBox();
            nameBox.add(Box.createVerticalStrut(10));
            JLabel fontNameLabel = new JLabel("Nazwa Czcionki");
            nameBox.add(fontNameLabel);
            if (listener != null) m_fontNameList.addListSelectionListener(listener);
            JScrollPane namePane = new JScrollPane(m_fontNameList);
            nameBox.add(namePane);
            nameBox.add(Box.createVerticalStrut(10));

            // Styl Czcionki
            Box styleBox = Box.createVerticalBox();
            styleBox.add(Box.createVerticalStrut(10));
            JLabel fontStyleLabel = new JLabel("Styl Czcionki : ");
            styleBox.add(fontStyleLabel);
            if (listener != null) m_fontStyleList.addListSelectionListener(listener);
            JScrollPane stylePane = new JScrollPane(m_fontStyleList);
            styleBox.add(stylePane);
            styleBox.add(Box.createVerticalStrut(10));

            // Rozmiar
            Box sizeBox = Box.createVerticalBox();
            sizeBox.add(Box.createVerticalStrut(10));
            JLabel fontSizeLabel = new JLabel("Rozmiar : ");
            sizeBox.add(fontSizeLabel);
            if (listener != null) m_fontSizeList.addListSelectionListener(listener);
            JScrollPane sizePane = new JScrollPane(m_fontSizeList);
            sizeBox.add(sizePane);
            sizeBox.add(Box.createVerticalStrut(10));

            Box mainBox = Box.createHorizontalBox();
            mainBox.add(Box.createHorizontalStrut(15));
            mainBox.add(nameBox);
            mainBox.add(Box.createHorizontalStrut(15));
            mainBox.add(styleBox);
            mainBox.add(Box.createHorizontalStrut(15));
            mainBox.add(sizeBox);
            mainBox.add(Box.createHorizontalStrut(15));
            add(mainBox, BorderLayout.CENTER);
        }

        /**
         * Zwraca wybraną czcionkę pochodzącą z
         * wyboru listy użytkownika.
         */
        public Font getSelectedFont() {
            //noinspection MagicConstant
            return new Font(m_fontNameList.getFontName(),
                    m_fontStyleList.getFontStyle(),
                    m_fontSizeList.getFontSize());
        }

        private final FontNameList m_fontNameList = new FontNameList();
        private final FontStyleList m_fontStyleList = new FontStyleList();
        private final FontSizeList m_fontSizeList = new FontSizeList();
    }

    /**
     * Klasa do prezentacji panelu podglądu zawierającego tekst
     * pokazuje wybraną czcionkę zgodnie z wyborem użytkownika
     *
     * atrybuty czcionki.
     */
    class PreviewPanel extends JPanel implements ListSelectionListener
    {

        /**
         * Wymagana metoda ListSelectionListener.
         */
        public void valueChanged(ListSelectionEvent ev)
        {
            Frame.textArea.setFont(FontChooser.this.getSelectedFont());
        }
    }
}

    /**
    * Klasa prezentująca dostępne style czcionek.
    */
    class FontNameList extends JList<String> {
    /**
     * Constructor
     */
    FontNameList() {
        super(m_fontNames);
        setSelectedIndex(0);
        setVisibleRowCount(12);
    }

    /**
     * Zwraca zaznaczoną nazwę czcionki
     */
    String getFontName()
    {
        return getSelectedValue();
    }
    private static final String[] m_fontNames =
            GraphicsEnvironment.getLocalGraphicsEnvironment().
                    getAvailableFontFamilyNames();
}

/**
 * Klasa prezentująca dostępne style
 */
class FontStyleList extends JList<String> {
    /**
     * Constructor
     */
    FontStyleList() {
        super(m_fontStyles);
        setSelectedIndex(0);
        setVisibleRowCount(12);
    }

    /**
     * Zwraca zaznaczony styl czcionki
     */
    int getFontStyle() {
        int style = 0;
        String name = getSelectedValue();
        switch (name) {
            case "Standardowy":
                break;
            case "Kursywa":
                style = Font.ITALIC;
                break;
            case "Pogrubiony":
                style = Font.BOLD;
                break;
            case "Pogrubiona Kursywa":
                style = Font.BOLD + Font.ITALIC;
                break;
        }
        return style;
    }
    private static final String[] m_fontStyles = {"Standardowy", "Kursywa", "Pogrubiony", "Pogrubiona Kursywa"};
}

    /**
    * Klasa prezentująca dostępne rozmiary czcionek.
     */

class FontSizeList extends JList<String> {
    /**
     * Constructor.
     */
    FontSizeList() {
        super(m_fontSizes);
        setSelectedIndex(9); // Domyślny to 11 punktów
        setVisibleRowCount(12);
    }

    /**
     * Zwraca wybrany rozmiar czcionki.
     */
    int getFontSize() {
        return Integer.parseInt(getSelectedValue());
    }

    private static final String[] m_fontSizes = {
                    "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "14", "16", "18",
                    "20", "22", "24", "26", "28", "30", "32", "36", "38", "48", "60", "72"
            };
}

    /**
    * Klasa do prezentacji okna dialogowego wyboru czcionki, składająca się
    * panelu FontChooser z przyciskami „OK” i „Anuluj”.
    */
class FontChooserDialog extends JDialog {
    /**
     * Konstruktor: Tworzy instancję FontChooserDialog.
     *
     * @param component nadrzędny komponent okna dialogowego
     * @param title tytuł okna dialogowego (dla paska tytułowego)
     * @param modal czy okno dialogowe jest modalne
     * @param chooserPane okienko FontChooser, które ma być używane
     * @param okListener to ActionListener, który słucha do przycisku OK
     * @param cancelListener to ActionListener, który nasłuchuje do przycisku Anuluj
     */

    public FontChooserDialog(Component component, String title, boolean modal, FontChooser chooserPane,
            ActionListener okListener, ActionListener cancelListener) {
        // Wywołaj konstruktor JDialog, przekazując rodzica
        // ramka komponentu.
        super(JOptionPane.getFrameForComponent(component), title, modal);

        // Ustawia zawartość okna dialogowego
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(chooserPane, BorderLayout.CENTER);

        // Tworzy dolny panel przycisków
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Przycisk OK
        JButton okButton = new JButton("OK");
        getRootPane().setDefaultButton(okButton);
        okButton.setActionCommand("OK");
        if (okListener != null) okButton.addActionListener(okListener);
        okButton.addActionListener(e -> setVisible(false)); // ukrywa okno dialogowe
        buttonPane.add(okButton);

        // Przycisk Anuluj
        JButton cancelButton = new JButton("Anuluj");
        cancelButton.setActionCommand("Anuluj");
        if (cancelListener != null) cancelButton.addActionListener(cancelListener);
        cancelButton.addActionListener(e -> setVisible(false)); // ukrywa okno dialogowe
        buttonPane.add(cancelButton);
        contentPane.add(buttonPane, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(component);
    }
    /**
     * Klasa do ukrywania okna dialogowego w przypadku zamknięcia okna.
     */
    static class Closer extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            Window w = e.getWindow();
            w.setVisible(false);
        }
    }

    /**
     * Klasa do usuwania okna dialogowego, gdy
     * okno dialogowe jest ukryte.
     */

    static class DisposeOnClose extends ComponentAdapter {
        public void componentHidden(ComponentEvent e)
        {
            Window w = (Window)e.getComponent();
            w.dispose();
        }
    }

}
    /**
    * Klasa do śledzenia zmian w wybranej czcionce
    * w FontChooser.
    */
class FontTracker implements ActionListener {
    public FontTracker(FontChooser chooser) { m_chooser = chooser; }
    public void actionPerformed(ActionEvent e) { m_font = m_chooser.getSelectedFont(); }
    public Font getSelectedFont() { return m_font; }

    private final FontChooser m_chooser;
    private Font m_font;
}