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


}