package com.hewen;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 2021/9/26
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@SpringBootApplication
@EnableBatchProcessing

public class ProcessorFileApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.hewen.itemProcessorDemo.ProcessorFileApplication.class, args);
    }
}