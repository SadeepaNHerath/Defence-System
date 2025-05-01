/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DesignPatern;

/**
 *
 * @author Dell
 */
public interface Observer {
    void getMsg(String msg);
    void UpdateArea(Boolean bol);
    void setButtons(int value);
    String getName();
    void giveInfo(int value);
    
}
