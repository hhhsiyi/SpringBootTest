import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 2022/2/15
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@SpringBootTest
public class SpringBootAppTest {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    void contextLoads(){

    }
}
