import com.hewen.SpringBatchApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 2021/6/28
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {SpringBatchApplication.class})
public class TestShowAllBeans {
@Autowired
    ApplicationContext applicationContext;

    @Test
    public void testAllBeans() throws Exception {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String bean :
                beanDefinitionNames) {
            System.out.println(bean);
        }
        System.out.println(beanDefinitionNames);
    }
    @Test
    public void testBeans() throws Exception {
        String displayName = applicationContext.getDisplayName();
//        for (String bean :
//                beanDefinitionNames) {
//            System.out.println(bean);
//        }
        System.out.println(displayName);
    }

}
