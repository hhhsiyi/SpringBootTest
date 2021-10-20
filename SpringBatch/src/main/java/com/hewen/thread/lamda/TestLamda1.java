package com.hewen.thread.lamda;

/**
 * 2021/10/19
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestLamda1 {
    //3.静态内部类
    static class Like2 implements ILike {
        @Override
        public void lam() {
            System.out.println("i like lamda2");
        }
    }
    public static void main(String[] args) {
        ILike iLike = new Like();
        iLike.lam();
        //3.静态内部类
        iLike = new Like2();
        iLike.lam();
        //4.局部内部类
        class Like3 implements ILike{
            @Override
            public void lam() {
                System.out.println("3");
            }
        }
        iLike = new Like3();
        iLike.lam();
        //5.匿名内部类，没有类的名称，必须借助接口或者父类
        iLike = new ILike() {
            @Override
            public void lam() {
                System.out.println("匿名内部类");
            }
        };
        iLike.lam();
        //6.lamda表达式简化
        iLike = ()-> {
            System.out.println("lamda表达式");
        };
        iLike.lam();
    }
}

//1.定义一个函数式接口
interface ILike {
    void lam();
}

//2.实现类
class Like implements ILike {
    @Override
    public void lam() {
        System.out.println("i like lamda");
    }
}