import javax.swing.*;
import java.awt.*;

/**
 *
 * @author zk-design
 */
public class MessageEdit extends JDialog {
    public MessageEdit() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {
        JLabel lblText = new JLabel();
        Button btnClose = new Button();
        int myWeight = Toolkit.getDefaultToolkit().getScreenSize().width;
        int myHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int widthFrame = 170;
        int heightFrame = 80;
        this.setLocation((myWeight - widthFrame)/2, (myHeight - heightFrame)/2);
        setUndecorated(true);
        setResizable(false);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        lblText.setBackground(new java.awt.Color(30, 30, 31));
        lblText.setFont(new java.awt.Font("Ubuntu", Font.BOLD, 14)); // NOI18N
        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setText("nie można już cofnąć");
        lblText.setToolTipText("");
        btnClose.setBackground(new java.awt.Color(65, 61, 61));
        btnClose.setFont(new java.awt.Font("Ubuntu", Font.BOLD, 14)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setLabel("ZAMKNIJ");
        btnClose.addActionListener(this::btnCloseActionPerformed);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.setVisible(Boolean.FALSE);
        this.dispose();
    }
}
