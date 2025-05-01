/*
 * Utility class for managing UI styles and appearance across the application
 */
package Utils;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Provides consistent styling for UI components across the Defence System
 * @author AI Assistant
 */
public class UIManager {
    // Color palette
    public static final Color BACKGROUND_DARK = new Color(45, 52, 54);
    public static final Color BACKGROUND_MEDIUM = new Color(87, 96, 111);
    public static final Color BACKGROUND_LIGHT = new Color(223, 230, 233);
    public static final Color TEXT_LIGHT = new Color(245, 246, 250);
    public static final Color TEXT_DARK = new Color(45, 52, 54);
    public static final Color ACCENT_GREEN = new Color(46, 204, 113);
    public static final Color ACCENT_RED = new Color(231, 76, 60);
    public static final Color ACCENT_BLUE = new Color(52, 152, 219);
    
    // Common fonts
    public static final Font TITLE_FONT = new Font("Segoe UI", Font.BOLD, 24);
    public static final Font SUBTITLE_FONT = new Font("Segoe UI", Font.BOLD, 16);
    public static final Font TEXT_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font BUTTON_FONT = new Font("Segoe UI", Font.BOLD, 14);
    
    // Common borders
    public static final Border ACCENT_BORDER = new LineBorder(ACCENT_BLUE, 2, true);
    public static final Border PANEL_BORDER = BorderFactory.createCompoundBorder(
            new LineBorder(BACKGROUND_MEDIUM, 1, true),
            BorderFactory.createEmptyBorder(5, 5, 5, 5));
    
    /**
     * Applies modern button styling
     * @param button The button to style
     */
    public static void styleButton(JButton button) {
        button.setFont(BUTTON_FONT);
        button.setBackground(ACCENT_BLUE);
        button.setForeground(TEXT_LIGHT);
        button.setFocusPainted(false);
        button.setBorderPainted(true);
        button.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(41, 128, 185), 1, true),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
    }
    
    /**
     * Applies modern styling to sliders
     * @param slider The slider to style
     */
    public static void styleSlider(JSlider slider) {
        slider.setBackground(BACKGROUND_DARK);
        slider.setForeground(TEXT_LIGHT);
        slider.setOpaque(false);
    }
    
    /**
     * Applies modern styling to text fields and areas
     * @param textComponent The text component to style
     */
    public static void styleTextComponent(JComponent textComponent) {
        textComponent.setFont(TEXT_FONT);
        textComponent.setBackground(BACKGROUND_LIGHT);
        textComponent.setForeground(TEXT_DARK);
        textComponent.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BACKGROUND_MEDIUM, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }
    
    /**
     * Applies modern styling to checkboxes
     * @param checkbox The checkbox to style
     */
    public static void styleCheckBox(JCheckBox checkbox) {
        checkbox.setFont(TEXT_FONT);
        checkbox.setForeground(TEXT_LIGHT);
        checkbox.setOpaque(false);
        checkbox.setFocusPainted(false);
    }
    
    /**
     * Applies modern styling to combo boxes
     * @param comboBox The combo box to style
     */
    public static void styleComboBox(JComboBox comboBox) {
        comboBox.setFont(TEXT_FONT);
        comboBox.setBorder(BorderFactory.createLineBorder(BACKGROUND_MEDIUM, 1));
        comboBox.setBackground(BACKGROUND_LIGHT);
        comboBox.setForeground(TEXT_DARK);
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, 
                    int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(
                        list, value, index, isSelected, cellHasFocus);
                
                if (isSelected) {
                    c.setBackground(ACCENT_BLUE);
                    c.setForeground(TEXT_LIGHT);
                } else {
                    c.setBackground(BACKGROUND_LIGHT);
                    c.setForeground(TEXT_DARK);
                }
                return c;
            }
        });
    }
    
    /**
     * Sets up the look and feel for the entire application
     */
    public static void setupLookAndFeel() {
        try {
            // Set system look and feel for native appearance
            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}