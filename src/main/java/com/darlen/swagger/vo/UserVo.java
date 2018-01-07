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
    private String userName;
    @ApiModelProperty(value = "用户年龄")
    private int age;

    public UserVo() {
    }

    public UserVo(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
