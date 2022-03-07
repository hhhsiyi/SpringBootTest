import com.hewen.mapper.UserMapper;
import com.hewen.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 2022/3/7
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@SpringBootTest
public class MybatisPlusApplicationTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        //查询全部用户；
        //参数是一个wapper(条件构造器)
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
    }
}
