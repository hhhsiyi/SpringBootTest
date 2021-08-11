package com.hewen.xmlBatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 2021/8/11
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@Component
public class BlackListLoader {

    private static final Logger LOG = LoggerFactory.getLogger(BlackListLoader.class);
    @Resource
    private JobLauncher jobLauncher;

    @Resource
    private Job blackListJob;
//    1、定义了一个名称为name的参数，值为%tb%。意思就是替换sql的模糊查询。
    public void loadBlackList() {
        try {
            JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
            jobParametersBuilder.addString("name", "%tb%");

            jobLauncher.run(blackListJob, jobParametersBuilder.toJobParameters());

        } catch (JobInstanceAlreadyCompleteException ex) {
            LOG.debug("This job has been completed already!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("over----------------");
    }
}
