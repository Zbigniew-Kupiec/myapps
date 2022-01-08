import javax.swing.*;
import java.awt.*;

/**
 *
 * @author zk-design
 */
public class MessagePrint extends JDialog {
    public MessagePrint() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {
        JLabel lblTextPrint = new JLabel();
        Button btnClosePrint = new Button();
        int myWeight = Toolkit.getDefaultToolkit().getScreenSize().width;
        int myHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int widthFrame = 170;
        int heightFrame = 80;
        this.setLocation((myWeight - widthFrame)/2, (myHeight - heightFrame)/2);
        setUndecorated(true);
        setResizable(false);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        lblTextPrint.setBackground(new java.awt.Color(30, 30, 31));
        lblTextPrint.setFont(new java.awt.Font("Ubuntu", Font.BOLD, 14)); // NOI18N
        lblTextPrint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTextPrint.setText("błąd drukowania - sprawdź");
        lblTextPrint.setToolTipText("");
        btnClosePrint.setBackground(new java.awt.Color(65, 61, 61));
        btnClosePrint.setFont(new java.awt.Font("Ubuntu", Font.BOLD, 14)); // NOI18N
        btnClosePrint.setForeground(new java.awt.Color(255, 255, 255));
        btnClosePrint.setLabel("ZAMKNIJ");
        btnClosePrint.addActionListener(this::btnCloseActionPerformed);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblTextPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnClosePrint, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTextPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnClosePrint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.setVisible(Boolean.FALSE);
        this.dispose();
    }
}
