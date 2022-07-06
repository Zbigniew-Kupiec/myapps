import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class WhiteTheme extends Frame{
    public WhiteTheme() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        super();
        UIManager.put("control", new ColorUIResource(0xFFFFFF));
        UIManager.put("text", new ColorUIResource(0x111111));
        UIManager.put("nimbusLightBackground", new ColorUIResource(new Color(0xD9D9D9)));
        UIManager.put("info", new ColorUIResource(new Color(0xFFFAFA)));
        UIManager.put("nimbusInfoBlue", new ColorUIResource(new Color(0xFFFAFA)));
        UIManager.put("nimbusBase", new ColorUIResource(new Color(0xFFFAFA)));
        UIManager.put("nimbusFocus", new ColorUIResource(new Color(0xFFFAFA)));
        UIManager.put("OptionPane.messageForeground", new Color(0, 0, 0, 215));
        UIManager.put("TextArea[Enabled+NotInScrollPane].borderPainter", new ColorUIResource(new Color(255, 255, 255, 0)));
        Frame.textArea.setBackground(new Color(255, 255, 255));
        Frame.textArea.setForeground(new Color(0, 0, 0, 215));
        Frame.status.setForeground(new Color(0, 0, 0, 215));
        UIManager.getLookAndFeelDefaults().put("textForeground", Color.BLACK);
        UIManager.getLookAndFeelDefaults().put("Menu.textForeground", Color.BLACK);
        UIManager.getLookAndFeelDefaults().put("ToolTip.textForeground", Color.BLACK);
        UIManager.getLookAndFeelDefaults().put("List.textForeground", Color.BLACK);
        UIManager.getLookAndFeelDefaults().put("TextField.foreground", Color.BLACK);
        UIManager.getLookAndFeelDefaults().put("TextArea.foreground", Color.BLACK);
        UIManager.getLookAndFeelDefaults().put("EditorPane.foreground", Color.BLACK);
        UIManager.put("nimbusBase", new Color(224, 224, 224));
        UIManager.getLookAndFeelDefaults().put("MenuItem[Enabled].textForeground", new Color(0, 0, 0, 215));
        UIManager.put("control", new Color(255, 255, 255));
        UIManager.put("Menu[Enabled].textForeground", new Color(0, 0, 0, 215));
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
