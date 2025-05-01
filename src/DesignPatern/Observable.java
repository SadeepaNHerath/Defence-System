/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DesignPatern;

import Units.Helicopter;
import Units.MainController;
import Units.Submarine;
import Units.Tank;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Observable {
    
    private static Observable instance;
    private static ArrayList<Observer> units;
    
    MainController main;
      
    private Observable(){}
    
    public static Observable getInstance(){
        if (instance == null) {
            instance = new Observable();
            units = new ArrayList<>();
        }
        return instance;
    }
    
    public void addUnit(Observer obj){
        units.add(obj);
    }
    
    public void addMain(MainController main){
        this.main=(main);
    }
    
    public void SendToMain(String msg){
        main.getMsg(msg);
    }
    
    public void SendToUnits(String msg){
        for (Observer ob : units){
            ob.getMsg(msg);
        }
    }
    
    public void UpdateArea(Boolean bol){
        for (Observer ob : units){
            ob.UpdateArea(bol);
        }
    }
    
    public void UpdateButton(int value){
        for (Observer ob : units){
            ob.setButtons(value);
        }
    }
    
    public int getStrength(){
        return main.getStrength();
    }
    public void sendToSub(String msg){
        for (Observer ob : units){
            if (ob instanceof Submarine ){
                ob.getMsg(msg);
            }
        }
    }
    
    public void sendToTank(String msg){
        for (Observer ob : units){
            if (ob instanceof Tank ){
                ob.getMsg(msg);
            }
        }
    }
    
    public void sendToHeli(String msg){
        for (Observer ob : units){
            if (ob instanceof Helicopter ){
                ob.getMsg(msg);
            }
        }
    }
    
    public void getInfo(String unit){
        for (Observer ob : units){
            if(unit.equals(ob.getName())){
                ob.giveInfo(main.getStrength());
            }
        }
    }
    
}
