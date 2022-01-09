import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;

abstract class ActionSave extends AbstractAction {
    public ActionSave(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
}

abstract class ActionOpen extends AbstractAction {
    public ActionOpen(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
}

class ActionNew extends AbstractAction {
    public ActionNew(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Frame.textArea.selectAll();
        Frame.textArea.setText(null);
        Frame.textArea.requestFocusInWindow();
    }

}
abstract class ActionLoad extends AbstractAction {
    public ActionLoad(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
}
class ActionEdit extends AbstractAction {
    public ActionEdit(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       try {
          Frame.textArea.setText(Frame.textArea.getText().substring(Frame.textArea.getText().indexOf(""),
                    Frame.textArea.getText().length() - 1));
        } catch (StringIndexOutOfBoundsException ex) {
                new MessageEdit().setVisible(true);
        }
    }
}

abstract class ActionFind extends AbstractAction {
    public ActionFind(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
}

class ActionCopy extends AbstractAction {
    public ActionCopy(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            Frame.textArea.copy();
    }
}

class ActionSelectAll extends AbstractAction {
    public ActionSelectAll(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Frame.textArea.selectAll();
    }
}

class ActionPaste extends AbstractAction {
    public ActionPaste(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            Frame.textArea.paste();
    }
}

class ActionCount extends AbstractAction {
    public ActionCount(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            new CountWords().setVisible(true);
    }
    @Override
    public boolean accept(Object sender) {
        return super.accept(sender);
    }
}

class ActionDelete extends AbstractAction {
    public ActionDelete(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Frame.textArea.getText();
        Frame.textArea.setText("");
    }

    @Override
    public boolean accept(Object sender) {
        return super.accept(sender);
    }
}

class ActionFonts extends AbstractAction {
    public ActionFonts(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new FontChooserFrame().setVisible(true);
    }

    @Override
    public boolean accept(Object sender) { return super.accept(sender); }
}

class ActionFontsColor extends AbstractAction {
    public ActionFontsColor(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new ColorChoose().setVisible(true);
    }
}

abstract class ActionExit extends AbstractAction {
    public ActionExit(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
}

abstract class ActionInfo extends AbstractAction {
    public ActionInfo(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
}

class ActionPrint extends AbstractAction {
    public ActionPrint(String name, String shortKey, Icon icon, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.SMALL_ICON, icon);
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Print.printComponent(Frame.textArea);
    }
}
class ActionSettingsBlack extends AbstractAction {
    public ActionSettingsBlack(String name, String shortKey, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        UIManager.put("control", new ColorUIResource(0x494949));
        UIManager.put("text", new ColorUIResource(0xFFFAFA));
        UIManager.put("nimbusLightBackground", new ColorUIResource(new Color(0, 0, 0, 215)));
        UIManager.put("info", new ColorUIResource(new Color(0, 0, 0, 215)));
        UIManager.put("nimbusInfoBlue", new ColorUIResource(new Color(0, 0, 0, 215)));
        UIManager.put("nimbusBase", new ColorUIResource(new Color(0, 0, 0, 215)));
        UIManager.put("nimbusFocus", new ColorUIResource(new Color(0, 0, 0, 215)));
        UIManager.put("OptionPane.messageForeground", new Color(224, 224, 224));
        UIManager.put("TextArea[Enabled+NotInScrollPane].borderPainter", new ColorUIResource(new Color(0, 0, 0, 0)));
        Frame.textArea.setBackground(new Color(0, 0, 0, 215));
        Frame.textArea.setForeground(new Color(224, 224, 224));
        UIManager.getLookAndFeelDefaults().put("textForeground", Color.WHITE);
        UIManager.getLookAndFeelDefaults().put("Menu.textForeground", Color.WHITE);
        UIManager.getLookAndFeelDefaults().put("ToolTip.textForeground", Color.WHITE);
        UIManager.getLookAndFeelDefaults().put("List.textForeground", Color.WHITE);
        UIManager.getLookAndFeelDefaults().put("TextField.foreground", Color.WHITE);
        UIManager.getLookAndFeelDefaults().put("TextArea.foreground", Color.WHITE);
        UIManager.getLookAndFeelDefaults().put("EditorPane.foreground", Color.WHITE);
        UIManager.put("nimbusBase", new Color(0, 0, 0, 215));
        UIManager.getLookAndFeelDefaults().put("MenuItem[Enabled].textForeground", new Color(225, 225, 225));
        UIManager.put("control", new Color(30, 30, 30));
        UIManager.put("Menu[Enabled].textForeground", new Color(225, 225, 225));
        Frame.status.setForeground(new Color(224, 224, 224));
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                break;
            }
        }

    }
}
class ActionSettingsWhite extends AbstractAction {
    public ActionSettingsWhite(String name, String shortKey, int mnemonicKey) {
        this.putValue(Action.NAME, name);
        this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        this.putValue(Action.MNEMONIC_KEY, mnemonicKey);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}