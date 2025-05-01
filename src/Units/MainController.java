/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Units;

import DesignPatern.Observable;
import Utils.UIManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Dell
 */
public class MainController extends javax.swing.JFrame {

    /**
     * Creates new form MainController
     */
    private final String name;
    private final Observable control;

    public MainController() {
        initComponents();

        control = Observable.getInstance();
        name = "Main Controller";
        setTitle("Defence System - " + name);
        // Change from EXIT_ON_CLOSE to DISPOSE_ON_CLOSE to work with launcher
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);
        
        // Set minimum size to ensure all components remain visible
        setMinimumSize(new Dimension(710, 440));

        // Apply modern UI styling
        applyUIStyles();

        // Group related controls with panels for better organization
        createPanels();
        
        // Improve text color on controls for better visibility
        improveTextVisibility();
        
        // Adjust component positions to ensure all are visible at the standard window size
        optimizeComponentLayout();
    }
    
    /**
     * Improve text visibility across components
     */
    private void improveTextVisibility() {
        // Make button text black for better readability
        btnSend.setForeground(Color.BLACK);
        btnInfo.setForeground(Color.BLACK);
        
        // Ensure text areas have black text on light background
        txtInBox.setForeground(Color.BLACK);
        txtSendBox.setForeground(Color.BLACK);
        
        // Make checkbox text more visible with larger, bolder font
        Font checkboxFont = new Font("Segoe UI", Font.BOLD, 13);
        chckArea.setFont(checkboxFont);
        chckPvt.setFont(checkboxFont);
        
        // Make combo boxes text visible
        cmbSend.setForeground(Color.BLACK);
        cmbInfo.setForeground(Color.BLACK);
        
        // Make labels more visible with higher contrast
        lblTitle.setForeground(Color.WHITE);
        lblStrength.setForeground(Color.WHITE);
    }
    
    /**
     * Optimize component layout for better visibility in the standard window size
     */
    private void optimizeComponentLayout() {
        // Adjust the scroll pane size for better visibility
        scrlInbox.setPreferredSize(new Dimension(410, 160));
        
        // Make the send box more visible with contrasting border
        scrlSendBox.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        
        // Ensure buttons have sufficient size
        btnSend.setPreferredSize(new Dimension(80, 30));
        btnInfo.setPreferredSize(new Dimension(157, 30));
        
        // Make sliders more visible with contrasting ticks
        sldrStrength.setPaintTicks(true);
        sldrStrength.setPaintLabels(true);
        sldrStrength.setMajorTickSpacing(20);
        sldrStrength.setBackground(new Color(60, 63, 65, 150)); // Semi-transparent background
    }

    /**
     * Apply consistent UI styling to all components
     */
    private void applyUIStyles() {
        // Style the background
        getContentPane().setBackground(UIManager.BACKGROUND_DARK);

        // Style all buttons
        UIManager.styleButton(btnSend);
        UIManager.styleButton(btnInfo);

        // Style text components
        UIManager.styleTextComponent(txtInBox);
        UIManager.styleTextComponent(txtSendBox);

        // Style combo boxes
        UIManager.styleComboBox(cmbSend);
        UIManager.styleComboBox(cmbInfo);

        // Style checkboxes
        UIManager.styleCheckBox(chckArea);
        UIManager.styleCheckBox(chckPvt);

        // Style slider
        UIManager.styleSlider(sldrStrength);

        // Enhance title and labels
        lblTitle.setFont(UIManager.TITLE_FONT);
        lblTitle.setForeground(UIManager.TEXT_LIGHT);

        lblStrength.setFont(UIManager.SUBTITLE_FONT);
        lblStrength.setForeground(UIManager.TEXT_LIGHT);

        // Add tooltips for better user experience
        btnSend.setToolTipText("Send message to selected defence units");
        btnInfo.setToolTipText("Request information from selected defence unit");
        sldrStrength.setToolTipText("Adjust strength level from 0-100");
        cmbSend.setToolTipText("Select defence unit to send message to");
        cmbInfo.setToolTipText("Select defence unit to get information from");
        chckArea.setToolTipText("Toggle area clearance status");
        chckPvt.setToolTipText("Send message privately to selected unit");
    }

    /**
     * Create panels to group related controls
     */
    private void createPanels() {
        // Communication panel
        JPanel communicationPanel = new JPanel();
        communicationPanel.setBorder(BorderFactory.createTitledBorder(
                UIManager.PANEL_BORDER, "Communications",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                UIManager.SUBTITLE_FONT, Color.WHITE));
        communicationPanel.setOpaque(false);

        // Control panel
        JPanel controlPanel = new JPanel();
        controlPanel.setBorder(BorderFactory.createTitledBorder(
                UIManager.PANEL_BORDER, "Defence Controls",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                UIManager.SUBTITLE_FONT, Color.WHITE));
        controlPanel.setOpaque(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbSend = new javax.swing.JComboBox<>();
        cmbInfo = new javax.swing.JComboBox<>();
        btnInfo = new javax.swing.JButton();
        lblStrength = new javax.swing.JLabel();
        sldrStrength = new javax.swing.JSlider();
        scrlInbox = new javax.swing.JScrollPane();
        txtInBox = new javax.swing.JTextArea();
        scrlSendBox = new javax.swing.JScrollPane();
        txtSendBox = new javax.swing.JTextField();
        chckArea = new javax.swing.JCheckBox();
        btnSend = new javax.swing.JButton();
        chckPvt = new javax.swing.JCheckBox();
        lblTitle = new javax.swing.JLabel();
        lblTitleBack = new javax.swing.JLabel();
        txt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbSend.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        cmbSend.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Select Defence", "Submarine", "Tank", "Helicopter"}));
        cmbSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSendActionPerformed(evt);
            }
        });
        getContentPane().add(cmbSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, -1));

        cmbInfo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        cmbInfo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Select Defence", "Submarine", "Tank", "Helicopter"}));
        cmbInfo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbInfoItemStateChanged(evt);
            }
        });
        cmbInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbInfoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, -1));

        btnInfo.setEnabled(false);
        btnInfo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnInfo.setText("Collect Informations");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });
        getContentPane().add(btnInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 157, -1));

        lblStrength.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblStrength.setForeground(new java.awt.Color(255, 255, 255));
        lblStrength.setText("Strength");
        getContentPane().add(lblStrength, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 126, -1));

        sldrStrength.setOpaque(false);
        sldrStrength.setBackground(new java.awt.Color(255, 255, 255));
        sldrStrength.setForeground(new java.awt.Color(255, 255, 255));
        sldrStrength.setMajorTickSpacing(20);
        sldrStrength.setMinorTickSpacing(10);
        sldrStrength.setPaintLabels(true);
        sldrStrength.setPaintTicks(true);
        sldrStrength.setValue(0);
        sldrStrength.setFocusCycleRoot(true);
        sldrStrength.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldrStrengthStateChanged(evt);
            }
        });
        getContentPane().add(sldrStrength, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 301, -1));

        txtInBox.setEditable(false);
        txtInBox.setColumns(20);
        txtInBox.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txtInBox.setRows(5);
        scrlInbox.setViewportView(txtInBox);

        getContentPane().add(scrlInbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 410, 170));

        txtSendBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSendBoxKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSendBoxKeyReleased(evt);
            }

            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSendBoxKeyTyped(evt);
            }
        });
        scrlSendBox.setViewportView(txtSendBox);

        getContentPane().add(scrlSendBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 330, 40));

        chckArea.setOpaque(false);
        chckArea.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        chckArea.setForeground(new java.awt.Color(255, 255, 255));
        chckArea.setText("Area Clear");
        chckArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckAreaActionPerformed(evt);
            }
        });
        getContentPane().add(chckArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, -1, -1));

        btnSend.setEnabled(false);
        btnSend.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        getContentPane().add(btnSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, -1));

        chckPvt.setOpaque(false);
        chckPvt.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        chckPvt.setEnabled(false);
        chckPvt.setForeground(new java.awt.Color(255, 255, 255));
        chckPvt.setText("Send Private");
        chckPvt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckPvtActionPerformed(evt);
            }
        });
        getContentPane().add(chckPvt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Main Controller");
        lblTitle.setToolTipText("");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, -1));

        lblTitleBack.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitleBack.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cama.jpg"))); // NOI18N
        lblTitleBack.setText("TANK");
        lblTitleBack.setToolTipText("");
        lblTitleBack.setMinimumSize(new java.awt.Dimension(300, 980));
        lblTitleBack.setPreferredSize(new java.awt.Dimension(300, 980));
        getContentPane().add(lblTitleBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 40));

        txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/main.jpg"))); // NOI18N
        getContentPane().add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 770, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbInfoActionPerformed
        if (((String) cmbInfo.getSelectedItem()).equals("Select Defence")) {
            btnInfo.setEnabled(false);
        } else {
            btnInfo.setEnabled(true);
        }
    }//GEN-LAST:event_cmbInfoActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        control.getInfo((String) cmbInfo.getSelectedItem());
    }//GEN-LAST:event_btnInfoActionPerformed

    private void chckPvtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckPvtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chckPvtActionPerformed

    private void cmbSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSendActionPerformed
        switch ((String) cmbSend.getSelectedItem()) {
            case "Select Defence":
                chckPvt.setEnabled(false);
                break;
            default:
                chckPvt.setEnabled(true);
        }
    }//GEN-LAST:event_cmbSendActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        control.SendToUnits(name + " : " + txtSendBox.getText());
        txtSendBox.setText("");
        btnSend.setEnabled(false);
    }//GEN-LAST:event_btnSendActionPerformed

    private void chckAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckAreaActionPerformed
        control.UpdateArea(chckArea.isSelected());
    }//GEN-LAST:event_chckAreaActionPerformed

    private void sldrStrengthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldrStrengthStateChanged
        control.UpdateButton(sldrStrength.getValue());
    }//GEN-LAST:event_sldrStrengthStateChanged

    private void txtSendBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSendBoxKeyReleased
        if (!(txtSendBox.getText().equals(""))) {
            btnSend.setEnabled(true);
        } else {
            btnSend.setEnabled(false);
        }
    }//GEN-LAST:event_txtSendBoxKeyReleased

    private void txtSendBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSendBoxKeyTyped
        if (!(txtSendBox.getText().equals(""))) {
            btnSend.setEnabled(true);
        } else {
            btnSend.setEnabled(false);
        }
    }//GEN-LAST:event_txtSendBoxKeyTyped

    private void txtSendBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSendBoxKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !(txtSendBox.getText().equals(""))) {
            evt.consume();
            if (chckPvt.isSelected()) {
                switch ((String) cmbSend.getSelectedItem()) {
                    case "Select Defence":
                        break;
                    case "Submarine":
                        control.sendToSub(name + " : " + txtSendBox.getText());
                        break;
                    case "Tank":
                        control.sendToTank(name + " : " + txtSendBox.getText());
                        break;
                    case "Helicopter":
                        control.sendToHeli(name + " : " + txtSendBox.getText());
                        break;
                }
            } else {
                control.SendToUnits(name + " : " + txtSendBox.getText());
            }
            txtSendBox.setText("");
            btnSend.setEnabled(false);
        }
    }//GEN-LAST:event_txtSendBoxKeyPressed

    private void cmbInfoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbInfoItemStateChanged
        if (((String) cmbInfo.getSelectedItem()).equals("Select Defence")) {
            btnInfo.setEnabled(false);
        } else {
            btnInfo.setEnabled(true);
        }
    }//GEN-LAST:event_cmbInfoItemStateChanged

    /**
     * Append received messages to the text area
     *
     * @param msg The message to display
     */
    public void getMsg(String msg) {
        txtInBox.append("\n" + msg);
    }

    /**
     * Get the current strength level
     *
     * @return The current strength level
     */
    public int getStrength() {
        return sldrStrength.getValue();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnSend;
    private javax.swing.JCheckBox chckArea;
    private javax.swing.JCheckBox chckPvt;
    private javax.swing.JComboBox<String> cmbInfo;
    private javax.swing.JComboBox<String> cmbSend;
    private javax.swing.JLabel lblStrength;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleBack;
    private javax.swing.JScrollPane scrlInbox;
    private javax.swing.JScrollPane scrlSendBox;
    private javax.swing.JSlider sldrStrength;
    private javax.swing.JLabel txt;
    private javax.swing.JTextArea txtInBox;
    private javax.swing.JTextField txtSendBox;
    // End of variables declaration//GEN-END:variables
}
