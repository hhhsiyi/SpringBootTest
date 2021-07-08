package com.hewen.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * 2021/7/7
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Configuration
@EnableBatchProcessing
public class SplitDemo {
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step splitStep1() {
        return stepBuilderFactory.get("splitStep1")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("splitStep1");
                        return RepeatStatus.FINISHED;
                    }//只有这个正常结束了，才能有下一个step执行的机会
                }).build();
    }

    @Bean
    public Step splitStep2() {
        return stepBuilderFactory.get("splitStep2")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("splitStep2");
                        return RepeatStatus.FINISHED;
                    }//只有这个正常结束了，才能有下一个step执行的机会
                }).build();
    }

    @Bean
    public Step splitStep3() {
        return stepBuilderFactory.get("splitStep3")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("splitStep3");
                        return RepeatStatus.FINISHED;
                    }//只有这个正常结束了，才能有下一个step执行的机会
                }).build();
    }

    @Bean
    public Flow splitFlow1() {
        return new FlowBuilder<Flow>("splitFlow1")
                .start(splitStep1())
                .build();
    }

    @Bean
    public Flow splitFlow2() {
        return new FlowBuilder<Flow>("splitFlow2")
                .start(splitStep2())
                .next(splitStep3())
                .build();
    }

    //创建job
    @Bean
    public Job splitJob() {
        return jobBuilderFactory.get("splitJob")
                .start(splitFlow1())
                .split(new SimpleAsyncTaskExecutor()).add(splitFlow2())
                //SimpleAsyncTaskExecutor 是异步执行的对象
                .end().build();

    }
}
