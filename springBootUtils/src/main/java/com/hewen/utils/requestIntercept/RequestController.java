package com.hewen.utils.requestIntercept;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2022/3/18
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
@RestController
public class RequestController {
    @PostMapping("test")
    public CommonResult test(@Validated @RequestBody RequestVo vo){

        return new CommonResult(0,"success");
    }
}
