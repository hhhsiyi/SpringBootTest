package com.hewen.thread.lamda;

/**
 * 2021/10/19
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class TestLamda2 {
    static class Love2 implements ILove{
        @Override
        public void Love(String a) {
            System.out.println("I Love "+a);
        }
    }
    public static void main(String[] args) {
        ILove love = new Love();
        love.Love("sss");
        love = new Love2();
        love.Love("sss");
        //4.局部内部类
        class Love3 implements ILove{
            @Override
            public void Love(String a) {
                System.out.println("I Love "+a);
            }
        }
        love = new Love3();
        love.Love("ssss");
        love = new ILove() {
            @Override
            public void Love(String a) {
                System.out.println("I love dsdda"+a);
            }
        };
        love.Love("sssssss");
        //lamda表达式方式
        love = (String a)->{
            System.out.println("dsadsad"+a);
        };
        love.Love("有参数类型何文");
        //简化1：去掉参数类型
        love = (a)->{
            System.out.println("dsadsad"+a);
        };
        love.Love("何文");
        //简化2：去掉括号
        love = a->{
            System.out.println("dsadsad"+a);
        };
        love.Love("111");
        //简化3：去掉大括号
        love = a-> System.out.println("dsadsad"+a);
        love.Love("去掉大括号");
        //总结：
        // 这里为什么能去掉大括号，是因为代码只有一行，如果代码有多行，其实是不能去掉大括号的！！！
        // 多个参数类型的时候，也可以去掉参数类型，但是要去掉就得一起去掉，必须加上括号

    }
}
interface ILove{
    void Love(String a);
}
//实现类
class Love implements ILove{
    @Override
    public void Love(String a) {
        System.out.println("I Love "+a);
    }
}