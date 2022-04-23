package com.hewen.pojo;

import com.hewen.utils.IDUtil;
import com.hewen.utils.MD5Util;
import lombok.Data;
import lombok.ToString;

/**
 * ClassName BilibiliUserInfo
 * Description
 * Create by Hewen
 * 早知如此绊人心，何如当初莫相识
 * Date 2022/4/20 18:01
 */
@Data
@ToString
public class BilibiliUserInfo {
    String name;
    String accountName;
    String password;
    String userToken;
//    String id = IDUtil.getUUID();
    String id = "";

}
