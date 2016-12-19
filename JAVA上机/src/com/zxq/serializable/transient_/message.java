package com.zxq.serializable.transient_;

import java.io.Serializable;

/**
 * Created by zhuxinquan on 16-12-19.
 */
public class message implements Serializable{
    String sender;
    String receiver;
    transient String action;
    String context;
    public message(String sender, String receiver, String action, String context){
        this.sender = sender;
        this.receiver = receiver;
        this.action = action;
        this.context = context;
    }
}
