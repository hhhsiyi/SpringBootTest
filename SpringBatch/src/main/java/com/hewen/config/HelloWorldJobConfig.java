package com.hewen.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2021/6/28
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Configuration
@EnableBatchProcessing
@RestController
public class HelloWorldJobConfig {
    //注入创建任务的对象
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    //任务的执行由Step决定
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    //创建的任务对象
    @Bean
    public Job helloWorldJob() {
        return jobBuilderFactory.get("helloWorldJob")
                .start(step10())//任务去执行step1
                .build();
    }
    @Bean
    public Step step10() {//创建了一个step，让helloWorldJob任务去执行step
        return stepBuilderFactory.get("step10")
                .tasklet(new Tasklet() {
                    //两种不同的生成方式
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("Hello World");
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

//@Autowired
//public TestMapper testMapper;
//    @RequestMapping("testMapper")
//    public String s(){
//return testMapper.c();
//    }
//@Autowired
//DataSource dataSource;
//    @RequestMapping("testSQL")
//    public void test2() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtils.getConnection(dataSource));
//        jdbcTemplate.execute("select 1 from dual");
//    }
//    @Bean
//    public Job helloWorlJob(JobBuilderFactory jobBuilders,
//                            StepBuilderFactory stepBuilders) {
//        return jobBuilders.get("helloWorldJob")
//                .start(helloWorldStep(stepBuilders)).build();
//    }
//
//    @Bean
//    public Step helloWorldStep(StepBuilderFactory stepBuilders) {
//        return stepBuilders.get("helloWorldStep")
//                .<Person, String>chunk(10).reader(reader())
//                .processor(processor()).writer(writer()).build();
//    }
//
//    @Bean
//    public FlatFileItemReader<Person> reader() {
//        return new FlatFileItemReaderBuilder<Person>()
//                .name("personItemReader")
//                .resource(new ClassPathResource("csv/persons.csv"))
//                .delimited().names(new String[] {"firstName", "lastName"})
//                .targetType(Person.class).build();
//    }
//
//    @Bean
//    public PersonItemProcessor processor() {
//        return new PersonItemProcessor();
//    }
//
//    @Bean
//    public FlatFileItemWriter<String> writer() {
//        return new FlatFileItemWriterBuilder<String>()
//                .name("greetingItemWriter")
//                .resource(new FileSystemResource(
//                        "target/test-outputs/greetings.txt"))
//                .lineAggregator(new PassThroughLineAggregator<>()).build();
//    }
}
