/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import javafx.scene.image.Image;


public class Fast extends Character{
    //atributos de clase
    
    
    private boolean stop;

    //constructor
    public Fast(int x, int y) {
        super(x, y);
    }//Fast

    //métodos accesores
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    
    public void setSpeed(int speed){
        this.speed=speed;
    }
    public int getSpeed(){
        return this.speed;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
    
}
    

