import javax.swing.*;
class FixedWidthLabel {
    public FixedWidthLabel() {
        Runnable runnable = () -> {
            String html = "<html><body width='%1s'><h1>Micro NOTE ® 2022.1 </h1>"
                    + "<p><b>Autor : </b> Zbyszek aka ZK - DESIGN</p>"
                    + "<p><b>Build : </b> #MN - 222.01.06</p>"
                    + "<p></p>"
                    + "<p><b>Micro NOTE</b> – prosty edytor tekstu z podstawowymi funkcjami.</p>"
                    + "<p></p></br>"
                    + "<p>Copyright © 2020 - 2022 ZK - DESIGN Inc.</p></body></html>";
            int h = 350;
            JOptionPane.showMessageDialog(null, String.format(html, h, h),
                    "Micro NOTE - Informacje", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("src\\img\\iconshelpapp.png"));
        };
        SwingUtilities.invokeLater(runnable);
    }
}