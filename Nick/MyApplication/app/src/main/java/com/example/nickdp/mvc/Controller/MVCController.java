package com.example.nickdp.mvc.Controller;

import com.example.nickdp.mvc.Model.Num;

/**
 * Created by NickDP on 21-09-2015.
 */
public class MVCController {

    private Num num;

    public MVCController(Num n){
        num = n;
    }

    public void increment(){
        int i = num.getNum();
        i++;
        num.setNum(i);
    }

    public void decrement(){
        int i = num.getNum();
        i--;
        num.setNum(i);
    }

}
