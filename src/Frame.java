import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class Frame extends JFrame {
    JMenu menuHelp;
    JMenu menuFile;
    JMenu menuSettings;
    private final JLabel status;
    public JMenu menuSize;
    static JMenu menuOption;
    public static JTextArea textArea;
    JScrollPane scrollPane;
    JFileChooser chooserFile;
    Action actionSave, actionNew, actionExit, actionLoad, actionOpen, actionFaq, actionFind, actionFontsColor, actionPrint,
            actionSettingsBlack, actionSettingsWhite;
    static Action actionEdit, actionCopy, actionPaste, actionCount, actionSelectAll, actionDelete, actionFonts;

    public Frame() throws ClassNotFoundException, UnsupportedLookAndFeelException,
            InstantiationException, IllegalAccessException {
        setTitle("Bez Tytułu - Mirco Note");
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                titleAlign(Frame.this);
            }

        });
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\img\\iconsmain.png"));
        this.setJMenuBar(menuBar);
        MyMenuBar();
        createArea();
        int myWeight = Toolkit.getDefaultToolkit().getScreenSize().width;
        int myHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setSize(myWeight/2, myHeight/2);
        int widthFrame = this.getSize().width;
        int heightFrame = this.getSize().height;
        this.setLocation((myWeight - widthFrame)/2, (myHeight - heightFrame)/2);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        UIManager.put("control", new ColorUIResource(0x494949));
        UIManager.put("text", new ColorUIResource(0xFFFAFA));
        UIManager.put("nimbusLightBackground", new ColorUIResource(new Color(0, 0, 0, 215)));
        UIManager.put("info", new ColorUIResource(new Color(0, 0, 0, 215)));
        UIManager.put("nimbusInfoBlue", new ColorUIResource(new Color(0, 0, 0, 215)));
        UIManager.put("nimbusBase", new ColorUIResource(new Color(0, 0, 0, 215)));
        UIManager.put("nimbusFocus", new ColorUIResource(new Color(0, 0, 0, 215)));
        this.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                final AWTEventListener hierarchyListener = event -> {
                    final HierarchyEvent he = (HierarchyEvent) event;
                    if (HierarchyEvent.HIERARCHY_CHANGED == he.getID() && he.getComponent() instanceof JOptionPane) {
                        final JDialog dlg = (JDialog) SwingUtilities.windowForComponent(he.getChangedParent());
                        if (dlg != null && !dlg.isUndecorated()) {
                            dlg.setUndecorated(true);
                        }
                    }
                };
                Toolkit.getDefaultToolkit().addAWTEventListener(hierarchyListener, AWTEvent.HIERARCHY_EVENT_MASK);
                Object[] options = {"Tak", "Zapisz", "Anuluj"};
                UIManager.put("OptionPane.messageForeground", new Color(224, 224, 224));
                int n = JOptionPane.showOptionDialog(Frame.this,
                        "Czy chcesz zamknąć program ?", "Wyjście z Programu",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                        new ImageIcon("src\\img\\iconsmain.png"), options, options);
                if (n == JOptionPane.YES_OPTION)
                    Frame.this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                if (n == JOptionPane.NO_OPTION)
                    saveToFile();
                if (n == JOptionPane.CANCEL_OPTION)
                    Frame.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        textArea.addCaretListener(this::caretUpdate);
        status = new JLabel();
        status.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        status.setPreferredSize(new Dimension(150, 30));
        add(status, BorderLayout.SOUTH);
        updateStatus(1,1);
    }

    private void titleAlign(JFrame frame) {
        Font font = frame.getFont();
        String currentTitle = frame.getTitle().trim();
        FontMetrics fm = frame.getFontMetrics(font);
        int frameWidth = frame.getWidth();
        int titleWidth = fm.stringWidth(currentTitle);
        int spaceWidth = fm.stringWidth(" ");
        int centerPos = (frameWidth / 2) - (titleWidth / 2);
        int spaceCount = centerPos / spaceWidth;
        String pad = "";
        pad = String.format("%" + (spaceCount - 14) + "s", pad);
        frame.setTitle(pad + currentTitle);
    }
    private void caretUpdate(CaretEvent e) {
        textArea = (JTextArea) e.getSource();
        int line = 1;
        int column = 1;
        try {
            int caretPosition = textArea.getCaretPosition();
            line = textArea.getLineOfOffset(caretPosition);
            column = caretPosition - textArea.getLineStartOffset(line);
            line += 1;
        }
        catch (BadLocationException ignored) {}
        updateStatus(line, column);
    }
    private void updateStatus(int linenumber, int columnnumber) {
        status.setText("Linia : " + linenumber  + "    " + " Kolumna : " + columnnumber + "    ");
        status.setForeground(new Color(224, 224, 224));
    }

    public void createArea() {
        textArea = new JTextArea();
        UIManager.put("TextArea[Enabled+NotInScrollPane].borderPainter", new ColorUIResource(new Color(0, 0, 0, 0)));
        textArea.setMargin(new Insets(0,0,0,0));
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        scrollPane = new JScrollPane(textArea);
        this.getContentPane().add(scrollPane);
        textArea.setBackground(new Color(0, 0, 0, 215));
        textArea.setForeground(new Color(224, 224, 224));
        pack();
    }
    public void localeSubPl(javax.swing.JComponent component) {
        UIManager.put("FileChooser.lookInLabelText","Szukaj w");
        UIManager.put("FileChooser.lookInLabelMnemonic","" + KeyEvent.VK_W);
        UIManager.put("FileChooser.saveInLabelText","Zapisz w");
        UIManager.put("FileChooser.saveInLabelMnemonic","" + KeyEvent.VK_W);
        UIManager.put("FileChooser.fileNameLabelText","Nazwa pliku:");
        UIManager.put("FileChooser.fileNameLabelMnemonic","" + KeyEvent.VK_N);
        UIManager.put("FileChooser.filesOfTypeLabelText","Pliki typu:");
        UIManager.put("FileChooser.filesOfTypeLabelMnemonic","" + KeyEvent.VK_P);
        UIManager.put("FileChooser.upFolderToolTipText","Poziom wyżej");
        UIManager.put("FileChooser.homeFolderToolTipText","Pulpit");
        UIManager.put("FileChooser.newFolderToolTipText","Nowy katalog");
        UIManager.put("FileChooser.listViewButtonToolTipText","Lista");
        UIManager.put("FileChooser.detailsViewButtonToolTipText","Szczegóły");
        UIManager.put("FileChooser.fileNameHeaderText","Nazwa");
        UIManager.put("FileChooser.fileSizeHeaderText","Rozmiar");
        UIManager.put("FileChooser.fileTypeHeaderText","Typ");
        UIManager.put("FileChooser.fileDateHeaderText","Modyfikacja");
        UIManager.put("FileChooser.fileAttrHeaderText","Atrybuty");
        UIManager.put("FileChooser.newFolderErrorText","Błąd podczas tworzenia katalogu");
        UIManager.put("FileChooser.saveButtonText","Zapisz");
        UIManager.put("FileChooser.saveButtonMnemonic","" + KeyEvent.VK_Z);
        UIManager.put("FileChooser.openButtonText","Otwórz");
        UIManager.put("FileChooser.openButtonMnemonic","" + KeyEvent.VK_O);
        UIManager.put("FileChooser.cancelButtonText","Anuluj");
        UIManager.put("FileChooser.openButtonMnemonic","" + KeyEvent.VK_R);
        UIManager.put("FileChooser.openDialogTitleText","Otwieranie");
        UIManager.put("FileChooser.saveDialogTitleText","Zapisywanie");
        UIManager.put("FileChooser.saveButtonToolTipText","Zapisanie pliku");
        UIManager.put("FileChooser.openButtonToolTipText","Otwarcie pliku");
        UIManager.put("FileChooser.cancelButtonToolTipText","Anuluj");
        UIManager.put("FileChooser.acceptAllFileFilterText","Wszystkie pliki");
        UIManager.put("FileChooser.directoryOpenButtonText", "Otwórz katalog");
        UIManager.put("FileChooser.directoryOpenButtonToolTipText", "Otwiera katalog");
        UIManager.put("FileChooser.foldersLabelText", "Nazwa folderu: ");
        UIManager.put("FileChooser.pathLabelText", "Ścieżka: ");
        UIManager.put("FileChooser.directoryDescriptionText", "Scieżka katalogu, opis");
        UIManager.put("FileChooser.foldersLabelText", "Foldery");
        UIManager.put("FileChooser.newFolderAccessibleName", "Nowy folder");
        UIManager.put("FileChooser.newFolderToolTipText", "Nowy folder");
        UIManager.put("FileChooser.other.newFolder", "Nowy folder");
        UIManager.put("FileChooser.other.newFolder.subsequent", "Nowy folder");
        UIManager.put("FileChooser.win32.newFolder", "Nowy folder");
        UIManager.put("FileChooser.win32.newFolder.subsequent", "Nowy folder");
        UIManager.getLookAndFeelDefaults().put("textForeground", Color.WHITE);
        UIManager.getLookAndFeelDefaults().put("Menu.textForeground", Color.WHITE);
        UIManager.getLookAndFeelDefaults().put("ToolTip.textForeground", Color.WHITE);
        UIManager.getLookAndFeelDefaults().put("List.textForeground", Color.WHITE);
        UIManager.getLookAndFeelDefaults().put("TextField.foreground", Color.WHITE);
        UIManager.getLookAndFeelDefaults().put("TextArea.foreground", Color.WHITE);
        UIManager.getLookAndFeelDefaults().put("EditorPane.foreground", Color.WHITE);
        SwingUtilities.updateComponentTreeUI(component);
    }

    public void saveToFile() {
        chooserFile.setDialogType(JFileChooser.SAVE_DIALOG);
        localeSubPl(chooserFile);
        if (actionSave != null) {
            int option = chooserFile.showSaveDialog(this);
            File file = chooserFile.getSelectedFile();
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedWriter buf = new BufferedWriter(new FileWriter(chooserFile.getSelectedFile().getAbsolutePath()));
                    buf.write(textArea.getText());
                    textArea.write(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
                    setTitle(chooserFile.getSelectedFile().getName() + " - Micro Note");
                    buf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    void MyMenuBar() throws ClassNotFoundException, UnsupportedLookAndFeelException,
            InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        UIManager.put("nimbusBase", new Color(0, 0, 0, 215));
        UIManager.getLookAndFeelDefaults().put("MenuItem[Enabled].textForeground", new Color(225, 225, 225));
        UIManager.put("control", new Color(30, 30, 30));
        UIManager.put("Menu[Enabled].textForeground", new Color(225, 225, 225));
        SwingUtilities.updateComponentTreeUI(this);
        chooserFile = new JFileChooser();
        menuFile = menuBar.add(new JMenu("Plik"));
        actionNew = new ActionNew("Nowy", "ctrl N",
                new ImageIcon("src\\img\\file.png"), KeyEvent.VK_N);
        menuFile.add(actionNew);
        menuFile.add(new JSeparator());
        actionLoad = new ActionLoad("Nowe Okno", "shift ctrl N",
                new ImageIcon("src\\img\\newwindow.png"), KeyEvent.VK_N) {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame frame = null;
                try {
                    frame = new Frame();
                } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException
                        | InstantiationException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                assert frame != null;
                frame.setVisible(true);
            }
        };
        menuFile.add(actionLoad);
        actionOpen = new ActionOpen("Otwórz", "ctrl O",
                new ImageIcon("src\\img\\open.png"), KeyEvent.VK_O) {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooserFile.setDialogType(JFileChooser.OPEN_DIALOG);
                localeSubPl(chooserFile);
                if (actionOpen != null) {
                    chooserFile.setFileFilter(new FiltrExtended("Pola tekstowe .txt, .iml, .xml, .java", EXTENDED_TEXT));
                    int option = chooserFile.showOpenDialog(Frame.this);
                    if(option == JFileChooser.APPROVE_OPTION) {
                        File file = chooserFile.getSelectedFile();
                        try {
                            BufferedReader input = new BufferedReader(new InputStreamReader(
                                    new FileInputStream(file)));
                            textArea.read(input, "Wczytywanie Pliku");
                            setTitle(chooserFile.getSelectedFile().getName() + " - Micro Note");
                        } catch (IOException evt) {
                            new MessageReadFile().setVisible(true);
                        }
                    }
                }
            }
        };
        menuFile.add(actionOpen);
        menuFile.add(new JSeparator());
        actionPrint = new ActionPrint("Drukuj", "ctrl P",
                new ImageIcon("src\\img\\print.png"), KeyEvent.VK_P);
        menuFile.add(actionPrint);
        menuFile.add(new JSeparator());
        actionSave = new ActionSave("Zapisz", "ctrl S",
                new ImageIcon("src\\img\\save.png"), KeyEvent.VK_S) {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        };
        menuFile.add(actionSave);
        actionExit = new ActionExit("Zamknij", "alt F4", new ImageIcon("src\\img\\close.png"),
                KeyEvent.VK_ALT + KeyEvent.VK_F4) {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.this.dispatchEvent(new WindowEvent(Frame.this, WindowEvent.WINDOW_CLOSING));
            }
        };
        menuFile.add(actionExit);
        menuOption = menuBar.add(new JMenu("Edycja"));
        actionFind = new ActionFind("Znajdź", "ctrl F",
                new ImageIcon("src\\img\\find.png"), KeyEvent.VK_F) {
            @Override
            public void actionPerformed(ActionEvent e) { new Finders(); }
        };
        menuOption.add(actionFind);
        actionEdit = new ActionEdit("Cofnij", "ctrl Z",
                new ImageIcon("src\\img\\back.png"), KeyEvent.VK_Z);
        menuOption.add(actionEdit);
        actionCopy = new ActionCopy("Kopiuj", "ctrl C",
                new ImageIcon("src\\img\\copy.png"), KeyEvent.VK_C);
        menuOption.add(actionCopy);
        actionSelectAll = new ActionSelectAll("Zaznacz wszystko", "ctrl A",
                new ImageIcon("src\\img\\select.png"), KeyEvent.VK_A);
        menuOption.add(actionSelectAll);
        actionPaste = new ActionPaste("Wklej", "ctrl V",
                new ImageIcon("src\\img\\paste.png"), KeyEvent.VK_V);
        menuOption.add(actionPaste);
        actionDelete = new ActionDelete("Usuń", "ctrl U",
                new ImageIcon("src\\img\\delete.png"), KeyEvent.VK_U);
        menuOption.add(actionDelete);
        actionCount = new ActionCount("Zliczanie słów", "ctrl L",
                new ImageIcon("src\\img\\word_count.png"), KeyEvent.VK_L);
        menuOption.add(actionCount);
        menuSize = menuBar.add(new JMenu("Format"));
        actionFonts = new ActionFonts("Czcionka", "ctrl T",
                new ImageIcon("src\\img\\font.png"), KeyEvent.VK_T);
        menuSize.add(actionFonts);
        actionFontsColor = new ActionFontsColor("Kolor Czcionki", "ctrl K",
                new ImageIcon("src\\img\\text_color_icon.png"), KeyEvent.VK_K);
        menuSize.add(actionFontsColor);
        menuHelp = menuBar.add(new JMenu("Pomoc"));
        actionFaq = new ActionInfo("Micro NOTE - Informacje","ctrl I",
                new ImageIcon("src\\img\\info.png"), KeyEvent.VK_I) {
            @Override
            public void actionPerformed(ActionEvent e) { new FixedWidthLabel(); }
        };
        menuHelp.add(actionFaq);
        menuSettings = menuBar.add(new JMenu("Ustawwienia"));
        actionSettingsBlack = new ActionSettingsBlack("Czarny Motyw", "ctrl B",
                new ImageIcon("src\\img\\text_color_icon.png"), KeyEvent.VK_B);
        actionSettingsWhite = new ActionSettingsWhite("Biały Motyw", "ctrl W",
                new ImageIcon("src\\img\\text_color_icon.png"), KeyEvent.VK_B);
        menuSettings.add(actionSettingsBlack);
    }

    public final JMenuBar menuBar = new JMenuBar();
    public final String[] EXTENDED_TEXT = new String[] {".txt", ".xml", ".iml", ".java"};

    public static class FiltrExtended extends FileFilter {
        public FiltrExtended(String info, String[] extended) {
            this.info = info;
            this.extended = extended;
        }
        @Override
        public boolean accept(File f) {
            for (String string : extended)
                if (f.getName().toLowerCase().endsWith(string) || f.isDirectory() || f.getName().endsWith(".java"))
                    return true;
            return f.isDirectory();
        }
        @Override
        public String getDescription()
        {
            return info;
        }
        public final String info;
        public final String[] extended;
    }
}




