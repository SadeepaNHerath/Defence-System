/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Start;

import DesignPatern.Observable;
import Units.Helicopter;
import Units.MainController;
import Units.Submarine;
import Units.Tank;
import Utils.UIManager;

/**
 *
 * @author Dell
 */
public class Start {
    
    public static void main(String[] args) {
        // Setup UI styling and look & feel
        UIManager.setupLookAndFeel();
        
        Observable controller = Observable.getInstance();
        
        Tank tank = new Tank();
        Helicopter heli = new Helicopter();
        Submarine sub = new Submarine();
        
        controller.addUnit(tank);
        controller.addUnit(heli);
        controller.addUnit(sub);
        
        // Configure window positions for better organization
        tank.setLocation(50, 100);
        heli.setLocation(750, 100);
        sub.setLocation(50, 550);
        
        tank.setVisible(true);
        heli.setVisible(true);
        sub.setVisible(true);
        
        MainController main = new MainController();
        controller.addMain(main);
        main.setLocation(750, 550);
        main.setVisible(true);
    }
}
