import javax.swing.*;
import java.awt.*;

/**
 *
 * @author zk-design
 */
public class MessageReadFile extends JDialog {

    private Point mouseDownCompCords = null;

    public MessageReadFile() {
        initComponents();
    }
    private void initComponents() {

        javax.swing.JLabel lblErrorEdit = new javax.swing.JLabel();
        javax.swing.JButton btnCloseEdit = new javax.swing.JButton();

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

        lblErrorEdit.setBackground(new java.awt.Color(30, 30, 31));
        lblErrorEdit.setFont(new java.awt.Font("Ubuntu", Font.BOLD, 24)); // NOI18N
        lblErrorEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorEdit.setText("BRAK PLIKU / BŁĄD... ");
        lblErrorEdit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(24, 22, 22), 2, false));
        lblErrorEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblErrorEdit, java.awt.BorderLayout.CENTER);

        btnCloseEdit.setFont(new java.awt.Font("Ubuntu", Font.PLAIN, 12)); // NOI18N
        btnCloseEdit.setText("ZAMKNIJ");
        btnCloseEdit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(24, 22, 22), 2, false));
        btnCloseEdit.setBackground(new java.awt.Color(24, 22, 22));
        btnCloseEdit.setForeground(new Color(255,255,255));
        btnCloseEdit.setFont(new java.awt.Font("Ubuntu", Font.BOLD, 12));
        btnCloseEdit.setPreferredSize(new java.awt.Dimension(80, 30));
        btnCloseEdit.addActionListener(this::btnCloseEditActionPerformed);
        getContentPane().add(btnCloseEdit, java.awt.BorderLayout.PAGE_END);
        pack();
    }
    private void btnCloseEditActionPerformed(java.awt.event.ActionEvent evt) {
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
