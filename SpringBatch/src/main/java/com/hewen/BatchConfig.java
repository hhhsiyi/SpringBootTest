package com.hewen;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 2021/6/28
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfigurer
{
    @Override
    public void setDataSource(DataSource dataSource) {
//        super.setDataSource(dataSource);
    }
}
