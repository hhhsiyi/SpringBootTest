import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hewen.MybatisPlusApplication;
import com.hewen.mapper.UserMapper;
import com.hewen.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * 2022/3/8
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisPlusApplication.class)
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        //name不为空，密码不为空
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("pwd")
                .ge("age",20)
                                            ;
        List<User> userList = userMapper.selectList(wrapper);
        userList.forEach(System.out::println);
    }

    @Test
    public void test02(){
        //name不为空，密码不为空
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","路淑妍");
        User user = userMapper.selectOne(wrapper);
        //查询一个，出现多个结果使用list 或者 map，不改的话就报错
        System.out.println(user);
    }

    @Test
    public void test03(){
        //年龄在20-200之间的
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,200);
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }

    @Test
    public void test04(){
        //模糊查询
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .like("name","何文")
                .likeRight("pwd","0928");
        //likeRight代表百分号在右边进行匹配，一般百分号放右边是不会索引失效的！
        List<Map<String,Object>> map = userMapper.selectMaps(wrapper);
        map.forEach(System.out::println);
    }

    @Test
    public void test05(){
        //子查询
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //id在子查询中查出来的
        wrapper.inSql("id","select id from user where id <3");
        List<Object> map = userMapper.selectObjs(wrapper);
        map.forEach(System.out::println);
    }

    @Test
    public void test06(){
        //排序
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //id在子查询中查出来的
        wrapper.orderByDesc("id");
        List<Object> map = userMapper.selectObjs(wrapper);
        map.forEach(System.out::println);
    }
}
