package com.example.nickdp.myfirstapp.MModel;

/**
 * Created by NickDP on 21-09-2015.
 */
public class Message extends Observable {

    private String msg;

    public void setMessage(String msg){
        this.msg = msg;
        notifyObservers(this);
    }

    public String getMessage(){
        return msg;
    }

}
