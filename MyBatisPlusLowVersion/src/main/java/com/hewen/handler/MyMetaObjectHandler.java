package com.hewen.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 2022/3/8
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Component //一定不要忘记把处理器加入到ioc容器中
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
//插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insert");
//        String fieldName, Object fieldVal, MetaObject metaObject
        this.setFieldValByName("create_time",new Date(),metaObject);
    }
//更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("update");
        this.setFieldValByName("update_time",new Date(),metaObject);
    }
}
