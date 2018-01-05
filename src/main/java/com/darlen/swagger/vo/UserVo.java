package com.darlen.swagger.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Description:
 *
 * @Author tree
 * @Date 2018/1/5 23:17
 * @Version 1.0
 */
@ApiModel(value = "用户信息")
public class UserVo {
    @ApiModelProperty(value = "用户id", required = true)
    private long userId;
    @ApiModelProperty(value = "昵称", required = true)
    private long userName;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserName() {
        return userName;
    }

    public void setUserName(long userName) {
        this.userName = userName;
    }
}
