package com.hewen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * 2021/6/28
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class PersonItemProcessor implements ItemProcessor<Person, String> {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public String process(Person person) throws Exception {
        String greeting = "Hello " + person.getFirstName() + " "
                + person.getLastName() + "!";

        LOGGER.info("converting '{}' into '{}'", person, greeting);
        return greeting;
    }
}
