/*
 * Launcher Window for Defence System
 */
package Start;

import DesignPatern.Observable;
import Units.Helicopter;
import Units.MainController;
import Units.Submarine;
import Units.Tank;
import Utils.UIManager;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * Launcher window with intro video and unit selection buttons
 * @author Defence System
 */
public class LauncherWindow extends JFrame {
    
    private JPanel contentPanel;
    private JPanel videoPanel;
    private JPanel buttonPanel;
    private JButton skipButton;
    private JButton tankButton;
    private JButton helicopterButton;
    private JButton submarineButton;
    private JButton mainControllerButton;
    
    private JLabel videoLabel;
    private Timer videoTimer;
    private int currentFrame = 1;
    private final int TOTAL_FRAMES = 50; // Adjust based on actual number of frames
    private final int FRAME_DELAY = 100; // milliseconds between frames
    
    private Observable controller;
    private Tank tank;
    private Helicopter heli;
    private Submarine sub;
    private MainController main;
    
    // Window dimensions for consistency - increased for better visibility
    private static final int UNIT_WIDTH = 800;
    private static final int UNIT_HEIGHT = 500;

    /**
     * Creates a new LauncherWindow
     */
    public LauncherWindow() {
        controller = Observable.getInstance();
        
        setTitle("Defence System - Launcher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        
        initComponents();
        startIntroVideo();
    }
    
    /**
     * Initialize the components of the launcher
     */
    private void initComponents() {
        contentPanel = new JPanel(new CardLayout());
        contentPanel.setBackground(UIManager.BACKGROUND_DARK);
        setContentPane(contentPanel);
        
        // Video panel (intro screen)
        videoPanel = new JPanel(new BorderLayout());
        videoPanel.setBackground(UIManager.BACKGROUND_DARK);
        
        // Create video display area
        videoLabel = new JLabel();
        videoLabel.setHorizontalAlignment(JLabel.CENTER);
        videoPanel.add(videoLabel, BorderLayout.CENTER);
        
        skipButton = new JButton("Skip Intro");
        UIManager.styleButton(skipButton);
        // Make skip button text black for better visibility
        skipButton.setForeground(Color.BLACK);
        skipButton.addActionListener(e -> {
            if (videoTimer != null && videoTimer.isRunning()) {
                videoTimer.stop();
            }
            showMainMenu();
        });
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(UIManager.BACKGROUND_DARK);
        bottomPanel.add(skipButton);
        videoPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        // Button panel (main menu)
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(UIManager.BACKGROUND_DARK);
        
        JLabel titleLabel = new JLabel("Defence System");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titleLabel.setForeground(UIManager.TEXT_LIGHT);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel subtitleLabel = new JLabel("Select a component to launch");
        subtitleLabel.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        subtitleLabel.setForeground(UIManager.TEXT_LIGHT);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        tankButton = createMenuButton("Launch Tank", "/Images/tank.jpg");
        helicopterButton = createMenuButton("Launch Helicopter", "/Images/helicopter.jpg");
        submarineButton = createMenuButton("Launch Submarine", "/Images/subMarine.jpg");
        mainControllerButton = createMenuButton("Launch Main Controller", "/Images/main.jpg");
        
        JButton exitButton = createMenuButton("Exit", null);
        
        JPanel buttonGrid = new JPanel(new GridLayout(2, 2, 20, 20));
        buttonGrid.setBackground(UIManager.BACKGROUND_DARK);
        buttonGrid.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonGrid.add(tankButton);
        buttonGrid.add(helicopterButton);
        buttonGrid.add(submarineButton);
        buttonGrid.add(mainControllerButton);
        
        JPanel paddingPanel = new JPanel();
        paddingPanel.setBackground(UIManager.BACKGROUND_DARK);
        paddingPanel.setPreferredSize(new Dimension(800, 50));
        
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(titleLabel);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(subtitleLabel);
        buttonPanel.add(Box.createVerticalStrut(40));
        buttonPanel.add(buttonGrid);
        buttonPanel.add(Box.createVerticalStrut(30));
        buttonPanel.add(exitButton);
        buttonPanel.add(Box.createVerticalStrut(50));
        
        // Add panels to content panel
        contentPanel.add(videoPanel, "video");
        contentPanel.add(buttonPanel, "menu");
        
        // Setup action listeners
        tankButton.addActionListener(e -> openTank());
        helicopterButton.addActionListener(e -> openHelicopter());
        submarineButton.addActionListener(e -> openSubmarine());
        mainControllerButton.addActionListener(e -> openMainController());
        exitButton.addActionListener(e -> System.exit(0));
        
        // Add window listeners for monitoring open windows
        addWindowMonitoring();
    }
    
    /**
     * Creates a styled menu button
     * @param text Button text
     * @param imagePath Path to button image or null
     * @return The styled button
     */
    private JButton createMenuButton(String text, String imagePath) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        // Change text color to black for better visibility
        button.setForeground(Color.BLACK);
        button.setBackground(UIManager.ACCENT_BLUE);
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(UIManager.BACKGROUND_LIGHT, 2));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Add an image if provided
        if (imagePath != null) {
            try {
                ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
                // Resize the image to a thumbnail
                Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                button.setIcon(new ImageIcon(img));
                button.setIconTextGap(10);
                button.setHorizontalTextPosition(SwingConstants.RIGHT);
                button.setVerticalTextPosition(SwingConstants.CENTER);
            } catch (Exception e) {
                System.err.println("Error loading image: " + imagePath);
            }
        }
        
        // Add hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(UIManager.ACCENT_GREEN);
                // Keep text black for readability
                button.setForeground(Color.BLACK);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(UIManager.ACCENT_BLUE);
                // Keep text black for readability
                button.setForeground(Color.BLACK);
            }
        });
        
        return button;
    }
    
    /**
     * Starts playing the intro video animation
     */
    private void startIntroVideo() {
        // If we have a real video, we would use JFXPanel or Media classes here
        // For now, we'll simulate a video with a series of images
        videoTimer = new Timer(FRAME_DELAY, e -> {
            if (currentFrame <= TOTAL_FRAMES) {
                // Update the frame display here
                updateVideoFrame(currentFrame);
                currentFrame++;
            } else {
                videoTimer.stop();
                showMainMenu();
            }
        });
        videoTimer.start();
        
        // Show first frame
        updateVideoFrame(1);
    }
    
    /**
     * Updates the displayed video frame
     * @param frameNumber The frame number to display
     */
    private void updateVideoFrame(int frameNumber) {
        // For demo, we'll just show text instead of video frames
        videoLabel.setText("Playing intro video frame " + frameNumber + "/" + TOTAL_FRAMES);
        videoLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        videoLabel.setForeground(UIManager.TEXT_LIGHT);
        
        // In reality, load actual frames from files or resources
        try {
            // Attempt to load a sample image instead of video frame
            URL imageURL = getClass().getResource("/Images/cama.jpg");
            if (imageURL != null) {
                ImageIcon icon = new ImageIcon(imageURL);
                Image img = icon.getImage().getScaledInstance(760, 450, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(img);
                videoLabel.setIcon(scaledIcon);
                
                // Add text overlay
                videoLabel.setText("Defence System - Initializing... " + 
                                   (int)(frameNumber * 100 / TOTAL_FRAMES) + "%");
                videoLabel.setHorizontalTextPosition(JLabel.CENTER);
                videoLabel.setVerticalTextPosition(JLabel.BOTTOM);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Shows the main menu after intro video
     */
    private void showMainMenu() {
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, "menu");
    }
    
    /**
     * Opens the Tank window
     */
    private void openTank() {
        if (tank == null || !tank.isVisible()) {
            tank = new Tank();
            controller.addUnit(tank);
            
            // Set consistent size
            tank.setSize(UNIT_WIDTH, UNIT_HEIGHT);
            tank.setLocationRelativeTo(null);
            
            tankButton.setEnabled(false);
            tank.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    tankButton.setEnabled(true);
                }
            });
            tank.setVisible(true);
        }
    }
    
    /**
     * Opens the Helicopter window
     */
    private void openHelicopter() {
        if (heli == null || !heli.isVisible()) {
            heli = new Helicopter();
            controller.addUnit(heli);
            
            // Set consistent size
            heli.setSize(UNIT_WIDTH, UNIT_HEIGHT);
            heli.setLocationRelativeTo(null);
            
            helicopterButton.setEnabled(false);
            heli.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    helicopterButton.setEnabled(true);
                }
            });
            heli.setVisible(true);
        }
    }
    
    /**
     * Opens the Submarine window
     */
    private void openSubmarine() {
        if (sub == null || !sub.isVisible()) {
            sub = new Submarine();
            controller.addUnit(sub);
            
            // Set consistent size
            sub.setSize(UNIT_WIDTH, UNIT_HEIGHT);
            sub.setLocationRelativeTo(null);
            
            submarineButton.setEnabled(false);
            sub.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    submarineButton.setEnabled(true);
                }
            });
            sub.setVisible(true);
        }
    }
    
    /**
     * Opens the Main Controller window
     */
    private void openMainController() {
        if (main == null || !main.isVisible()) {
            main = new MainController();
            controller.addMain(main);
            
            // Set consistent size
            main.setSize(UNIT_WIDTH, UNIT_HEIGHT);
            main.setLocationRelativeTo(null);
            
            mainControllerButton.setEnabled(false);
            main.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    mainControllerButton.setEnabled(true);
                }
            });
            main.setVisible(true);
        }
    }
    
    /**
     * Add window monitoring to detect closed windows
     */
    private void addWindowMonitoring() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Clean up when launcher is closed
                if (tank != null && tank.isVisible()) {
                    tank.dispose();
                }
                if (heli != null && heli.isVisible()) {
                    heli.dispose();
                }
                if (sub != null && sub.isVisible()) {
                    sub.dispose();
                }
                if (main != null && main.isVisible()) {
                    main.dispose();
                }
            }
        });
    }
}