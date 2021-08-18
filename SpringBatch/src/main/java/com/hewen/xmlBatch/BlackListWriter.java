package com.hewen.xmlBatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * 2021/8/11
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */

@Component
public class BlackListWriter implements ItemWriter<BlackListEntity> {
    private static final Logger LOG = LoggerFactory.getLogger(BlackListEntity.class);

    @Override
    public void write(List<? extends BlackListEntity> blackListEntities) throws IOException {
        FileWriter fileWriter = new FileWriter("test");

        try {
            for (BlackListEntity blackList : blackListEntities) {
                System.out.println("spring batch writer show"+blackList.getName());
                fileWriter.write(blackList.getName());
            }
        } catch (Exception ple) {
            LOG.debug(ple.getMessage());
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
