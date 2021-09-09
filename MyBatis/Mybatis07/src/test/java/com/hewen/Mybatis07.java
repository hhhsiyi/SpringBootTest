package com.hewen;

import com.hewen.mapper.StudentMapper;
import com.hewen.mapper.TeacherMapper;
import com.hewen.pojo.Student;
import com.hewen.pojo.Teacher;
import com.hewen.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021/8/20
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Mybatis07 {
//    一对多处理
    @Test
    public void test01(){
//        SqlSession sqlSession = MyBatisUtils.getSqlSession();
//        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
//        List<Teacher> teacher = mapper.getTeacher();
//        for (Teacher teacher1 : teacher) {
//            System.out.println(teacher1);
//        }
    }
    @Test
    public void test02(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
//        Teacher teacher = mapper.getTeacher(1);
//        Teacher teacher = mapper.getTeacher(1);
//        System.out.println(teacher);
        List<Teacher> teacher = mapper.getTeacher(1);
        for (Teacher teacher1 : teacher) {
            System.out.println(teacher1);
        }
        //System.out.println(teacher);
    }
    @Test
    public void test05(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
//        Teacher teacher = mapper.getTeacher(1);
//        Teacher teacher = mapper.getTeacher(1);
//        System.out.println(teacher);
        List<Teacher> teacher = mapper.getTeacher2(1);
        for (Teacher teacher1 : teacher) {
            System.out.println(teacher1);
        }
        //System.out.println(teacher);
    }
    @Test
    public void test03(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent();
        for (Student student1 : student) {
            System.out.println(student1);
        }
    }
    @Test
    public void test04(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        List<String> student = mapper.getStudent1();
        System.out.println(mapper.getStudent1());
//        for (String s : student) {
//            System.out.println(s);
//        }
    }
    @Test
    public void testLog(){
        List<String> strings = new ArrayList<String>();
        //Logger logger = LoggerFactory.getLogger(Mybatis07.class.getName());
    }
}
