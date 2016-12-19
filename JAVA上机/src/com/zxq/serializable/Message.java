package com.zxq.serializable;

import java.io.Serializable;

/**
 * Created by zhuxinquan on 16-12-19.
 */
public class Message implements Serializable {
    String sender;
    String receiver;
    transient String action;
    String context;
    public Message(String sender, String receiver, String action, String context){
        this.sender = sender;
        this.receiver = receiver;
        this.action = action;
        this.context = context;
    }
}
