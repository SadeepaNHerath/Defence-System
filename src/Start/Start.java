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

/**
 *
 * @author Dell
 */
public class Start {
    
    public static void main(String[] args) {
        
        Observable controller = Observable.getInstance();
        
        Tank tank = new Tank();
        Helicopter heli = new Helicopter();
        Submarine sub = new Submarine();
        
        controller.addUnit(tank);
        controller.addUnit(heli);
        controller.addUnit(sub);
        
        tank.setVisible(true);
        heli.setVisible(true);
        sub.setVisible(true);
        
        
        MainController main =new MainController();
        controller.addMain(main);
        main.setVisible(true);
    }
    

}
