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
@RequestMapping("/user")
@Api(description = "用户相关接口文档")
public class SwaggerController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", notes = "增加用户")
    public Result<UserVo> add(@ApiParam(name = "token", value = "token", required = true) @RequestParam(name = "token", required = true) String token,
                              @ApiParam(name = "userName", value = "用户昵称", required = true) @RequestParam(name = "userName", required = true) String userName,
                              @ApiParam(name = "mobile", value = "手机", required = true) @RequestParam(name = "mobile", required = true) String mobile,
                              @ApiParam(required = true, name = "email", value = "邮箱") @RequestParam(name = "email", required = true) String email) {

        return new Result<UserVo>(Constants.SUCCESS, Constants.MSG_SUCCESS, new UserVo());
    }

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = { "" }, method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        users.put(Long.valueOf(user.getId()), user);
        return "success";
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User") })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
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

class User {
    String age;
    int id;
    String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
