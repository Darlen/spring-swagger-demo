package com.darlen.swagger.controller;

import com.alibaba.fastjson.JSON;
import com.darlen.swagger.constants.Constants;
import com.darlen.swagger.constants.Result;
import com.darlen.swagger.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @Author tree
 * @Date 2018/1/6 10:15
 * @Version 1.0
 */
@Api(description = "用户接口文档")
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", notes = "增加用户")
    public Result<UserVo> add(
            @ApiParam(name = "userName", value = "用户昵称", required = true)
            @RequestParam(name = "userName") String userName,
//            @ApiParam(name = "age", value = "年龄", required = true )
            @RequestParam(name = "age") int age) {
        return new Result<UserVo>(Constants.SUCCESS, Constants.MSG_SUCCESS, new UserVo(userName,age));
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(System.getProperties()));
    }
}
