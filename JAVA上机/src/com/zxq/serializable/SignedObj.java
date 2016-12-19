package com.zxq.serializable;

import java.io.Serializable;
import java.security.PublicKey;

/**
 * Created by zhuxinquan on 16-12-18.
 */
public class SignedObj implements Serializable {
    byte [] b;
    byte [] sig;
    PublicKey pub;
    public SignedObj(byte [] b, byte [] sig, PublicKey pub){
        this.b = b;
        this.sig = sig;
        this.pub = pub;
    }
}
