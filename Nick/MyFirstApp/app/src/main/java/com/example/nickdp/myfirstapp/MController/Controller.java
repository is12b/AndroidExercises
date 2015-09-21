package com.example.nickdp.myfirstapp.MController;

import com.example.nickdp.myfirstapp.MModel.Message;

/**
 * Created by NickDP on 21-09-2015.
 */
public class Controller {

    private Message msg;

    public Controller(Message msg){
        this.msg = msg;
    }

    public void appendMessage(String text){
        String txt = msg.getMessage();

        if(txt == null){
            txt = text;
        } else {
            txt += "\n" + text;
        }

        msg.setMessage(txt);
    }

}
