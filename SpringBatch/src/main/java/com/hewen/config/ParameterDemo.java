package com.hewen.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 2021/7/16
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Configuration
@EnableBatchProcessing
//@ConfigurationProperties(prefix = "parameter")
public class ParameterDemo implements StepExecutionListener {
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;
    private final Logger logger = LoggerFactory.getLogger(ParentJob1.class);
    //@Value("${parameter.map}")
    private Map<String, String > parameters1;

    private Map<String, JobParameter> parameters;

    JobParameter s = new JobParameter("2");
    @Value("${parameter.test}")
    private String t;
    @Value("${parameter.s1}")
    private String s1;
    @Value("${parameter.s2}")
    private String s2;
    @Bean
    public Job parameterJob() {
        return jobBuilderFactory.get("parameterJob")
                .start(parameterStep())
                .build();
    }

    @Bean
//给step传递参数
//使用step级别的监听传递数据
//
    public Step parameterStep() {
        return stepBuilderFactory.get("parameterStep")
                .listener(this)
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        parameters.put(s1,new JobParameter(s2));
                        System.out.println(1);
                        System.out.println(parameters.get("info"));
                        System.out.println(2);
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        parameters = stepExecution.getJobParameters().getParameters();
//在step执行之前就已经赋值给上面了，当step执行的时候就可以获取这个值了
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}
