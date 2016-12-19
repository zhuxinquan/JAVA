package com.zxq.serializable;

import java.io.Serializable;

/**
 * Created by zhuxinquan on 16-12-19.
 */
public class subject  implements Serializable {
    String name;
    float score;
    public subject(String name, float score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "subject{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
