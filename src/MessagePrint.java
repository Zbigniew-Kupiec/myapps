import javax.swing.*;
import java.awt.*;

/**
 *
 * @author zk-design
 */
public class MessagePrint extends JDialog {

    private Point mouseDownCompCords = null;

    public MessagePrint() {
        initComponents();
    }
    private void initComponents() {

        javax.swing.JLabel lblError = new javax.swing.JLabel();
        javax.swing.JButton btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconImages(null);
        setLocation(new java.awt.Point(500, 350));
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setMaximumSize(new java.awt.Dimension(400, 110));
        setMinimumSize(new java.awt.Dimension(400, 110));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(400, 110));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        lblError.setBackground(new java.awt.Color(30, 30, 31));
        lblError.setFont(new java.awt.Font("Ubuntu", Font.BOLD, 24)); // NOI18N
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setText("BŁĄD DRUKOWANIA ... ");
        lblError.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(24, 22, 22), 2, false));
        lblError.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblError, java.awt.BorderLayout.CENTER);

        btnClose.setFont(new java.awt.Font("Ubuntu", Font.PLAIN, 12)); // NOI18N
        btnClose.setText("ZAMKNIJ");
        btnClose.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(24, 22, 22), 2, false));
        btnClose.setBackground(new java.awt.Color(24, 22, 22));
        btnClose.setForeground(new Color(255,255,255));
        btnClose.setFont(new java.awt.Font("Ubuntu", Font.BOLD, 12));
        btnClose.setPreferredSize(new java.awt.Dimension(80, 30));
        btnClose.addActionListener(this::btnCloseActionPerformed);
        getContentPane().add(btnClose, java.awt.BorderLayout.PAGE_END);
        pack();
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(Boolean.FALSE);
        this.dispose();
    }
    private void formMouseDragged(java.awt.event.MouseEvent evt) {
        Point currCords = evt.getLocationOnScreen();
        this.setLocation(currCords.x - mouseDownCompCords.x, currCords.y - mouseDownCompCords.y);
    }
    private void formMousePressed(java.awt.event.MouseEvent evt) { mouseDownCompCords = evt.getPoint(); }
    private void formMouseReleased(java.awt.event.MouseEvent ignoredEvt) { mouseDownCompCords = null; }
}
