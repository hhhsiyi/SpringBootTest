package com.hewen.itemProcessorDemo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import javax.sql.DataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2021/9/26
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Configuration
public class ProcessorFileOutputFromDBConfiguration {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ItemProcessor<Person, Person> fristNameUpperCaseProcessor;

    @Autowired
    private ItemProcessor<Person, Person> idFilterProcessor;

    @Bean
    public Job ProcessorFileOutputFromDBJob() {
        return jobBuilderFactory.get("ProcessorFileOutputFromDBJob")
                .start(ProcessorFileOutputFromDBStep())
                .build();

    }

    @Bean
    public Step ProcessorFileOutputFromDBStep() {
        return stepBuilderFactory.get("ProcessorFileOutputFromDBStep")
                .<Person, Person>chunk(100)
                .reader(ProcessorFileOutputFromItemWriter())
                .processor(personDataProcessor())
                .writer(ProcessorFileOutputFromItemReader())
                .build();
    }

    @Bean
    @StepScope
    public JdbcPagingItemReader<Person> ProcessorFileOutputFromItemWriter() {
        JdbcPagingItemReader<Person> reader = new JdbcPagingItemReader<>();
        reader.setDataSource(this.dataSource); // 设置数据源
        reader.setFetchSize(100); // 设置一次最大读取条数
        reader.setRowMapper(new PersonRowMapper()); // 把数据库中的每条数据映射到AlipaytranDo对像中
        MySqlPagingQueryProvider queryProvider = new MySqlPagingQueryProvider();
        queryProvider.setSelectClause("id,name,per_desc,create_time,update_time,sex,score,price"); // 设置查询的列
        queryProvider.setFromClause("from person_buf"); // 设置要查询的表
        Map<String, Order> sortKeys = new HashMap<String, Order>();// 定义一个集合用于存放排序列
        sortKeys.put("id", Order.ASCENDING);// 按照升序排序
        queryProvider.setSortKeys(sortKeys);
        reader.setQueryProvider(queryProvider);// 设置排序列
        return reader;
    }

    @Bean
    public CompositeItemProcessor<Person, Person> personDataProcessor(){
        CompositeItemProcessor<Person, Person> processor=new CompositeItemProcessor<>();
        List<ItemProcessor<Person, Person>> listProcessor=new ArrayList<>();
        listProcessor.add(fristNameUpperCaseProcessor);
        listProcessor.add(idFilterProcessor);
        processor.setDelegates(listProcessor);
        return processor;

    }

    @Bean
    @StepScope
    public FlatFileItemWriter<Person> ProcessorFileOutputFromItemReader() {
        FlatFileItemWriter<Person> writer = new FlatFileItemWriter<Person>();
        try {
            File path = new File("D:" + File.separator + "newPerson.json").getAbsoluteFile();
            System.out.println("file is create in :" + path);
            writer.setResource(new FileSystemResource(path));
            writer.setLineAggregator(new PersonLineAggregator());
            writer.afterPropertiesSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return writer;
    }

}