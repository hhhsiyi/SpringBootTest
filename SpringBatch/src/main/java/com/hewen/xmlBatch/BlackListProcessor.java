package com.hewen.xmlBatch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * 2021/8/11
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */

@Component
public class BlackListProcessor implements ItemProcessor<BlackListEntity,BlackListEntity> {
    @Override
    public BlackListEntity process(BlackListEntity item) throws Exception {
        item.setName(item.getName()+"-ByProcessor");
        return item;
    }

}
