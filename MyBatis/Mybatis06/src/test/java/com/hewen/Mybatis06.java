package com.hewen;

import com.hewen.mapper.StudentMapper;
import com.hewen.mapper.TeacherMapper;
import com.hewen.pojo.Student;
import com.hewen.pojo.Teacher;
import com.hewen.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 2021/8/20
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Mybatis06 {
    @Test
    public void test01(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
    @Test
    public void test03(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = studentMapper.getStudent();
        //System.out.println(student);
        for (Student student1 : student) {
            System.out.println(student1);
        }
        sqlSession.close();
    }
    @Test
    public void test04(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = studentMapper.getStudent2();
        //System.out.println(student);
        for (Student student1 : student) {
            System.out.println(student1);
        }
        sqlSession.close();
    }
    @Test
    public void test02(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        List<Map<String, String>> student = mapper.getStudent();
        List<Student> student = mapper.getStudent();
        for (Student student1 : student) {
            System.out.println(student1);
        }
//        System.out.println(student);
        sqlSession.close();
    }
    @Test
    public void testLog(){
        Logger logger = LoggerFactory.getLogger(Mybatis06.class.getName());
    }
}
