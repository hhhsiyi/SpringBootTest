package com.hewen.config;

import com.hewen.listener.MyChunkListener;
import com.hewen.listener.MyJobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * 2021/7/8
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Configuration
@EnableBatchProcessing
public class ListenerDemo {
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;
    private final Logger logger = LoggerFactory.getLogger(ParentJob1.class);

    @Bean
    public Job listenerJob() {
        return jobBuilderFactory.get("listenerJob")
                .start(stept())
                .listener(new MyJobListener())
                .build();
    }

    @Bean
    public Step stept() {
        logger.info("testLog");
        return stepBuilderFactory.get("stept")
                .<String, String>chunk(2)//类似切片频率,可以读取和写入数据
                .faultTolerant() //容错
                .listener(new MyChunkListener())
                .reader(read())
                .writer(write())
                .build();

    }

    @Bean
    public ItemWriter<String> write() {
        return new ItemWriter<String>() {
            @Override
            public void write(List<? extends String> items) throws Exception {
                for (String item :
                        items) {
                    System.out.println(item);
                }
            }
        };
    }

    //    private ItemWriter<? super Object> write() {
//        return null;
//    }
    @Bean
    public ItemReader<String> read() {
        return new ListItemReader<>(Arrays.asList("java", "spring", "mybatis"));
    }

}
