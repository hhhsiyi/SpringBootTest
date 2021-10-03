package com.hewen.itemProcessorDemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.file.transform.LineAggregator;

/**
 * 2021/9/26
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class PersonLineAggregator implements LineAggregator<Person> {
    //JSON
    private ObjectMapper mapper=new ObjectMapper();

    @Override
    public String aggregate(Person person) {
        try {
            return mapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("unable to writer...",e);
        }
    }

}