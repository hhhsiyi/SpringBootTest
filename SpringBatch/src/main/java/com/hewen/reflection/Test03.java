package com.hewen.reflection;

/**
 * ClassName Test03
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2021/12/26 17:02
 */
//测试class类的创建方式有哪些
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是"+person.name);
        //开始了
        //方式1：通过对象获得
        Class c1 = person.getClass();
        //方式2：forname获得
        Class c2 = Class.forName("com.hewen.reflection.Student");
        //都是同一个class，打印hashCode看看
//        System.out.println(c1.hashCode()+" "+c2.hashCode());
        //方式3：通过类名.class
        Class c3 = Student.class;
        //方式4：基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println(c1.hashCode()+" "+c2.hashCode()+" "+c3.hashCode()+"\n"+c4);
        //获得父类类型
        Class c5 = c1.getSuperclass();
    }
}
class Person{
    public String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }
}
class Student extends Person{
    public Student(){
        this.name="学生";
    }
}
class Teacher extends Person{
    public Teacher(){
        this.name="老师";
    }
}