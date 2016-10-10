package design_pattern.oberver_pattern;

import java.util.Observable;

/**
 * Created by zhuxinquan on 16-8-18.
 */
public class Goods extends Observable {
    private float price;

    public Goods(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
        this.setChanged();
        this.notifyObservers();
    }
}
