/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Units;
import DesignPatern.Observable;
import DesignPatern.Observer;
import Utils.UIManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Dell
 */
public class Helicopter extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form Helicopter
     */
    
    private final String name;
    private final Observable control;
    
    public Helicopter() {
        initComponents();
        
        control = Observable.getInstance();
        name = "Helicopter";
        setTitle("Defence System - " + name);
        // Change from EXIT_ON_CLOSE to DISPOSE_ON_CLOSE to work with launcher
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);
        
        // Set appropriate size to ensure all components remain visible
        setSize(new Dimension(800, 500));
        
        // Apply modern UI styling
        applyUIStyles();
        
        // Create panels for better organization
        createPanels();
        
        // Improve text visibility
        improveTextVisibility();
        
        // Optimize component layout for standard window size
        optimizeComponentLayout();
    }
    
    /**
     * Apply consistent UI styling to components
     */
    private void applyUIStyles() {
        // Style the background
        getContentPane().setBackground(UIManager.BACKGROUND_DARK);
        
        // Style all buttons with better visibility
        UIManager.styleButton(btnShoot);
        UIManager.styleButton(btnMissile);
        UIManager.styleButton(btnLaser);
        UIManager.styleButton(btnSend);
        
        // Style the labels with better visibility
        lblTitle.setFont(UIManager.TITLE_FONT);
        lblTitle.setForeground(UIManager.TEXT_LIGHT);
        
        lblArea.setFont(UIManager.SUBTITLE_FONT);
        lblArea.setForeground(UIManager.TEXT_LIGHT);
        
        lblFuel.setFont(UIManager.TEXT_FONT);
        lblFuel.setForeground(UIManager.TEXT_LIGHT);
        
        lblSoldier.setFont(UIManager.TEXT_FONT);
        lblSoldier.setForeground(UIManager.TEXT_LIGHT);
        
        lblAmmo.setFont(UIManager.TEXT_FONT);
        lblAmmo.setForeground(UIManager.TEXT_LIGHT);
        
        // Style text components for better readability
        UIManager.styleTextComponent(txtInBox);
        UIManager.styleTextComponent(txtSendBox);
        
        // Style slider
        UIManager.styleSlider(sldrFuel);
        
        // Style checkbox
        UIManager.styleCheckBox(chckPosition);
        
        // Add tooltips for better usability
        btnShoot.setToolTipText("Fire weapons");
        btnMissile.setToolTipText("Launch missiles");
        btnLaser.setToolTipText("Activate laser targeting system");
        btnSend.setToolTipText("Send message to command center");
        sldrFuel.setToolTipText("Current fuel level");
        spnrAmmo.setToolTipText("Available ammunition");
        spnrSoldier.setToolTipText("Crew count");
        chckPosition.setToolTipText("Toggle helicopter position");
    }
    
    /**
     * Improve text visibility across components
     */
    private void improveTextVisibility() {
        // Make button text black for better readability
        btnShoot.setForeground(Color.BLACK);
        btnMissile.setForeground(Color.BLACK);
        btnLaser.setForeground(Color.BLACK);
        btnSend.setForeground(Color.BLACK);
        
        // Ensure text areas have black text on light background
        txtInBox.setForeground(Color.BLACK);
        txtSendBox.setForeground(Color.BLACK);
        
        // Make checkbox text more visible
        chckPosition.setForeground(Color.WHITE);
        
        // Make labels more visible with higher contrast
        lblTitle.setForeground(Color.WHITE);
        lblArea.setForeground(Color.WHITE);
        lblSoldier.setForeground(Color.WHITE);
        lblAmmo.setForeground(Color.WHITE);
        lblFuel.setForeground(Color.WHITE);
        
        // Add borders to make areas more distinct
        scrlInbox.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.WHITE, 1), 
                "Communication Log", 
                TitledBorder.DEFAULT_JUSTIFICATION, 
                TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.BOLD, 12),
                Color.WHITE));
        
        scrlSent1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    }
    
    /**
     * Optimize component layout for standard window size
     */
    private void optimizeComponentLayout() {
        // Make the fuel slider more visible with better contrast
        sldrFuel.setOpaque(false);
        sldrFuel.setBackground(new Color(60, 63, 65, 150)); // Semi-transparent background
        
        // Ensure button has sufficient size
        btnSend.setPreferredSize(new Dimension(80, 30));
        
        // Make spinners more visible
        spnrAmmo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        spnrSoldier.setFont(new Font("Segoe UI", Font.BOLD, 12));
    }
    
    /**
     * Create panels to group related controls
     */
    private void createPanels() {
        // Create weapons panel
        JPanel weaponsPanel = new JPanel();
        weaponsPanel.setBorder(BorderFactory.createTitledBorder(
                UIManager.PANEL_BORDER, "Weapons Control", 
                TitledBorder.DEFAULT_JUSTIFICATION, 
                TitledBorder.DEFAULT_POSITION, 
                UIManager.SUBTITLE_FONT, Color.WHITE));
        weaponsPanel.setOpaque(false);
        weaponsPanel.setBounds(5, 90, 290, 80);
        getContentPane().add(weaponsPanel);
        
        // Create resources panel
        JPanel resourcesPanel = new JPanel();
        resourcesPanel.setBorder(BorderFactory.createTitledBorder(
                UIManager.PANEL_BORDER, "Resources", 
                TitledBorder.DEFAULT_JUSTIFICATION, 
                TitledBorder.DEFAULT_POSITION, 
                UIManager.SUBTITLE_FONT, Color.WHITE));
        resourcesPanel.setOpaque(false);
        resourcesPanel.setBounds(430, 60, 210, 100);
        getContentPane().add(resourcesPanel);
        
        // Create status panel
        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(BorderFactory.createTitledBorder(
                UIManager.PANEL_BORDER, "Status", 
                TitledBorder.DEFAULT_JUSTIFICATION, 
                TitledBorder.DEFAULT_POSITION, 
                UIManager.SUBTITLE_FONT, Color.WHITE));
        statusPanel.setOpaque(false);
        statusPanel.setBounds(5, 50, 128, 40);
        getContentPane().add(statusPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblArea = new javax.swing.JLabel();
        btnShoot = new javax.swing.JButton();
        btnMissile = new javax.swing.JButton();
        btnLaser = new javax.swing.JButton();
        scrlInbox = new javax.swing.JScrollPane();
        txtInBox = new javax.swing.JTextArea();
        scrlSent1 = new javax.swing.JScrollPane();
        txtSendBox = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        lblSoldier = new javax.swing.JLabel();
        lblAmmo = new javax.swing.JLabel();
        spnrSoldier = new javax.swing.JSpinner();
        spnrAmmo = new javax.swing.JSpinner();
        sldrFuel = new javax.swing.JSlider();
        chckPosition = new javax.swing.JCheckBox();
        lblTitle = new javax.swing.JLabel();
        lblTitleBack = new javax.swing.JLabel();
        lblFuel = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblArea.setFont(lblArea.getFont().deriveFont(lblArea.getFont().getStyle() | java.awt.Font.BOLD, 13));
        lblArea.setForeground(new java.awt.Color(255, 255, 255));
        lblArea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArea.setText("Area Not Cleared");
        getContentPane().add(lblArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 128, 29));

        btnShoot.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnShoot.setText("Shoot");
        btnShoot.setEnabled(false);
        getContentPane().add(btnShoot, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, -1));

        btnMissile.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnMissile.setText("Missile Operation");
        btnMissile.setEnabled(false);
        getContentPane().add(btnMissile, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 140, -1));

        btnLaser.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLaser.setText("Laser Operation");
        btnLaser.setEnabled(false);
        getContentPane().add(btnLaser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 140, -1));

        txtInBox.setEditable(false);
        txtInBox.setBackground(new java.awt.Color(242, 242, 242));
        txtInBox.setColumns(20);
        txtInBox.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txtInBox.setRows(5);
        scrlInbox.setViewportView(txtInBox);

        getContentPane().add(scrlInbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 620, 139));

        txtSendBox.setBackground(new java.awt.Color(242, 242, 242));
        txtSendBox.setColumns(20);
        txtSendBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSendBox.setRows(5);
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
        scrlSent1.setViewportView(txtSendBox);

        getContentPane().add(scrlSent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 520, 30));

        btnSend.setEnabled(false);
        btnSend.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnSend.setText("Send");
        btnSend.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        getContentPane().add(btnSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 81, 30));

        lblSoldier.setFont(lblSoldier.getFont().deriveFont(lblSoldier.getFont().getStyle() | java.awt.Font.BOLD, 13));
        lblSoldier.setForeground(new java.awt.Color(255, 255, 255));
        lblSoldier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSoldier.setText("Soldier Count");
        getContentPane().add(lblSoldier, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 123, 29));

        lblAmmo.setFont(lblAmmo.getFont().deriveFont(lblAmmo.getFont().getStyle() | java.awt.Font.BOLD, 13));
        lblAmmo.setForeground(new java.awt.Color(255, 255, 255));
        lblAmmo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAmmo.setText("Ammo Count");
        getContentPane().add(lblAmmo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 123, 29));

        spnrSoldier.setValue(10);
        getContentPane().add(spnrSoldier, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 70, -1));

        spnrAmmo.setValue(50);
        getContentPane().add(spnrAmmo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 70, -1));

        sldrFuel.setOpaque(false);
        sldrFuel.setBackground(new java.awt.Color(255, 255, 255));
        sldrFuel.setForeground(new java.awt.Color(255, 255, 255));
        sldrFuel.setMajorTickSpacing(20);
        sldrFuel.setMinorTickSpacing(10);
        sldrFuel.setOrientation(javax.swing.JSlider.VERTICAL);
        sldrFuel.setPaintLabels(true);
        sldrFuel.setPaintTicks(true);
        sldrFuel.setValue(100);
        getContentPane().add(sldrFuel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, -1, 340));

        chckPosition.setOpaque(false);
        chckPosition.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        chckPosition.setForeground(new java.awt.Color(255, 255, 255));
        chckPosition.setText("Position");
        chckPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckPositionActionPerformed(evt);
            }
        });
        getContentPane().add(chckPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, -1, -1));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Helicopter");
        lblTitle.setToolTipText("");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, -1));

        lblTitleBack.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitleBack.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cama.jpg"))); // NOI18N
        lblTitleBack.setText("TANK");
        lblTitleBack.setToolTipText("");
        lblTitleBack.setMinimumSize(new java.awt.Dimension(300, 980));
        lblTitleBack.setPreferredSize(new java.awt.Dimension(300, 980));
        getContentPane().add(lblTitleBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 40));

        lblFuel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblFuel.setForeground(new java.awt.Color(255, 255, 255));
        lblFuel.setText("Fuel ⛽");
        getContentPane().add(lblFuel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 50, 20));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/helicopter.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 40, 950, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        control.SendToMain(name + " : " + txtSendBox.getText());        
        txtSendBox.setText("");
        btnSend.setEnabled(false);
    }//GEN-LAST:event_btnSendActionPerformed

    private void chckPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckPositionActionPerformed
        setButtons(control.getStrength());
    }//GEN-LAST:event_chckPositionActionPerformed

    private void txtSendBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSendBoxKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !(txtSendBox.getText().equals(""))) {
            evt.consume();
            control.SendToMain(name + " : " + txtSendBox.getText());
            txtSendBox.setText("");
            btnSend.setEnabled(false);
        }else if(!(txtSendBox.getText().equals(""))){
            btnSend.setEnabled(true);
        }else{
            btnSend.setEnabled(false);
        }
    }//GEN-LAST:event_txtSendBoxKeyPressed

    private void txtSendBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSendBoxKeyReleased
        if(!(txtSendBox.getText().equals(""))){
            btnSend.setEnabled(true);
        }else{
            btnSend.setEnabled(false);
	}
    }//GEN-LAST:event_txtSendBoxKeyReleased

    private void txtSendBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSendBoxKeyTyped
       if(!(txtSendBox.getText().equals(""))){
            btnSend.setEnabled(true);
        }else{
            btnSend.setEnabled(false);
	}
    }//GEN-LAST:event_txtSendBoxKeyTyped
    
    /**
     *
     * @param msg
     */
    @Override
    public void getMsg(String msg){
        txtInBox.append("\n" + msg);
    }
    
    /**
     *
     * @param bol
     */
    @Override
    public void UpdateArea(Boolean bol){
        if (bol == true){
            lblArea.setText("Area Cleared");
        }else{
            lblArea.setText("Area Not Cleared");
        }
    }
    
    @Override
    public void setButtons(int value){
        if (chckPosition.isSelected()){
                if (value>=20){
                    btnShoot.setEnabled(true);
                }else{
                    btnShoot.setEnabled(false);
                }
                if(value>=40){
                    btnMissile.setEnabled(true);
                }else{
                    btnMissile.setEnabled(false);
                }
                if(value>=60){
                    btnLaser.setEnabled(true);
                }else{
                    btnLaser.setEnabled(false);
                }
        }else{
            btnShoot.setEnabled(false);
            btnMissile.setEnabled(false);
            btnLaser.setEnabled(false);
        }
    }
    
    public String getName(){
        return name;
    }
    
    /**
     *
     * @param value
     */
    @Override
    public void giveInfo(int value){
        String btnInfo = "" ;
        if (chckPosition.isSelected()){
                if (value>=20){
                    btnInfo += "Shooting Button Available.. \n";
                }
                if(value>=40){
                    btnInfo += "Sonar Operation Available.. \n";
                }
                if(value>=60){
                   btnInfo += "Laser Operation Available.. \n";
                }
        }
                
        String count = "Soldier Count : " + spnrSoldier.getValue() +"\nAmmo Count :" + spnrAmmo.getValue() + "\nFuel Availability : " + sldrFuel.getValue() + "\n" ;
        JOptionPane.showMessageDialog(null, (count + btnInfo) , " Helicopter Info ", JOptionPane.INFORMATION_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaser;
    private javax.swing.JButton btnMissile;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnShoot;
    private javax.swing.JCheckBox chckPosition;
    private javax.swing.JLabel lblAmmo;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblFuel;
    private javax.swing.JLabel lblSoldier;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleBack;
    private javax.swing.JScrollPane scrlInbox;
    private javax.swing.JScrollPane scrlSent1;
    private javax.swing.JSlider sldrFuel;
    private javax.swing.JSpinner spnrAmmo;
    private javax.swing.JSpinner spnrSoldier;
    private javax.swing.JTextArea txtInBox;
    private javax.swing.JTextArea txtSendBox;
    // End of variables declaration//GEN-END:variables
}
