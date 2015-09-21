package com.example.nickdp.mvc.Model;

/**
 * Created by NickDP on 21-09-2015.
 */
public class Num extends Observable {
    
    public void setNum(int i) {
        this.num = i;
        notifyObservers(this);
    }

    private int num = 0;

    public int getNum() {
        return num;
    }
}
