package com.zxq.shiyansan;

/**
 * Created by zhuxinquan on 16-4-13.
 */
public class Example {
    public static void main(String [] args){
        Rectangle r = new Rectangle(20, 20);
        Cube c = new Cube(11, 22, 33);
        System.out.println("矩形的面积" + r.getArea());
        System.out.println("长方体的体积" + c.getVol());
        System.out.println("长方体的面积" + c.getArea());
        //底边为3, 4, 5的三角形，高为２的三棱柱
        Prism p = new Prism(3, 4, 5, 2);
        System.out.println("三棱柱体积为：" + p.getVol());
        System.out.println("三棱柱表面积：" + p.getArea());
        Cylinder cy = new Cylinder(2, 3);
        System.out.println("圆柱体积：" + cy.getVol());
        System.out.println("圆柱表面积" + cy.getArea());
    }
}
