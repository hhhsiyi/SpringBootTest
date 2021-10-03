package com.hewen.itemProcessorDemo;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * 2021/9/26
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Component
public class IdFilterProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person item) throws Exception {
        if (item.getId() % 2 == 0) {
            return item;
        } else {
            return null;
        }
    }

}