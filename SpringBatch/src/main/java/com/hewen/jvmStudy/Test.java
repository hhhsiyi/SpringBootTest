package com.hewen.jvmStudy;

/**
 * ClassName Test
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/1/19 22:35
 */
public class Test {
    private int a;
    private String name = "hewen";

    public static void main(String[] args) {
        new Test();//对象在堆里
        Test test = new Test();//引用在栈里
        //如果我们什么都不做，
        //name 就在常量池里
        //如果
        test.name="hewenww";
        //name就在堆里！
    }
}
