/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Start;

import Utils.UIManager;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dell
 */
public class Start {
    
    public static void main(String[] args) {
        // Setup UI styling and look & feel
        UIManager.setupLookAndFeel();
        
        // Launch the intro window with SwingUtilities to ensure proper EDT usage
        SwingUtilities.invokeLater(() -> {
            LauncherWindow launcher = new LauncherWindow();
            launcher.setVisible(true);
        });
    }
}
