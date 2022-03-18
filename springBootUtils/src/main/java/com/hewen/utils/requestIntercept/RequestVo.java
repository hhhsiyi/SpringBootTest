package com.hewen.utils.requestIntercept;

//import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotBlank;

/**
 * 2022/3/18
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class RequestVo {
//     1.@NotNull：不能为null，但可以为empty(""," ","   ")
//   2.@NotEmpty：不能为null，而且长度必须大于0 (" ","  ")
//   3.@NotBlank：只能作用在String上，不能为null，而且调用trim()后，长度必须大于0("test")    即：必须有实际字符
    @NotBlank(message = "统一id不能为空")
    private String id;//统一id
    @NotBlank(message = "身份证号不能为空")
    private String proveNo;//身份证

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProveNo() {
        return proveNo;
    }

    public void setProveNo(String proveNo) {
        this.proveNo = proveNo;
    }
}
