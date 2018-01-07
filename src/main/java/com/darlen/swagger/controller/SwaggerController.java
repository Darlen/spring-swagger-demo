package com.darlen.swagger.controller;

import com.darlen.swagger.constants.Constants;
import com.darlen.swagger.constants.Result;
import com.darlen.swagger.vo.UserVo;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Description:
 *
 * @Author tree
 * @Date 2018/1/5 23:16
 * @Version 1.0
 */
@RestController
@RequestMapping("/swagger")
@Api(description = "Swagger相关接口文档")
public class SwaggerController {

    private static Map<Long, UserVo> users = Collections.synchronizedMap(new HashMap<Long, UserVo>());



    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @RequestMapping(value = "getUserList" , method = RequestMethod.GET)
    public List<UserVo> getUserList() {
        List<UserVo> r = new ArrayList<UserVo>(users.values());
        return r;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postUser(@RequestBody UserVo user) {
        users.put(Long.valueOf(user.getUserId()), user);
        return "success";
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserVo getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User") })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody UserVo user) {
        UserVo u = users.get(id);
        u.setUserName(user.getUserName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}

