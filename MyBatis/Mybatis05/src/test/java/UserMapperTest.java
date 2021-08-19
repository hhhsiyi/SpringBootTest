import com.hewen.mapper.UserMapper;
import com.hewen.pojo.User1;
import com.hewen.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * 2021/8/6
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
//这里测试属性名和数据库字段名不一致的情况
public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);//因为可能在多个场景使用，因此提升作用域

    @Test
    public void test() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        try {//获得SqlSession对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User1> users =  mapper.getUsers();
            System.out.println(users);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void test2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {//获得SqlSession对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User1 userById = mapper.getUserById(1);
            System.out.println(userById);
            User1 hewen = mapper.getUserById2(1, "hewen");
            System.out.println(hewen);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void test3() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {//获得SqlSession对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User1 user1= mapper.getUserById3(new User1(1, "cmd", "19980928"));
            System.out.println(user1);
            int hello = mapper.addUser(new User1(11, "hello", "199"));
            System.out.println(mapper.getUserById(11));
            //sqlSession.commit();
//            int cmd = mapper.addUser(new User1(11, "cmd", "19980928"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void test4() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {//获得SqlSession对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User1 user1= mapper.getUserById3(new User1(1, "cmd", "19980928"));
            System.out.println(mapper.getUserById(1));
            int hello = mapper.updateUser(new User1(1, "hello", "199"));
            System.out.println(mapper.getUserById(1));
            //sqlSession.commit();
//            int cmd = mapper.addUser(new User1(11, "cmd", "19980928"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void test5() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {//获得SqlSession对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int hello = mapper.addUser(new User1(11, "hello", "199"));
            System.out.println(mapper.getUserById(11));
            int t =  mapper.deleteUser(11);
            System.out.println(mapper.getUserById(11));
            //sqlSession.commit();
//            int cmd = mapper.addUser(new User1(11, "cmd", "19980928"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}