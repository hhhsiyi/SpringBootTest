package com.hewen.factory.simple;

/**
 * 2021/10/1
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//静态工厂模式
    //增加一个新的产品，必须要增加代码
    //开闭原则
public class CarFactory {
    //方法一
    public static Car getCar(String car){
        if (car.equals("五菱")){
            return new WuLing();
        }else if (car.equals("特斯拉"))
        {
            return new Tesla();
        }
        else {
            return null;
        }
    }
    //方法二
    public static Car getWuling(){
        return new WuLing();
    }
    public static Car getTesla(){
        return new Tesla();
    }
    //后果：方法膨胀

}
