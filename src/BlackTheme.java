import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class BlackTheme extends Frame{
    public BlackTheme() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        super();
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
