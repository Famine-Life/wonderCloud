package com.wonder.auth.controller;

import com.wonder.auth.service.ISysUserService;
import com.wonder.common.base.SuperRest;
import com.wonder.common.exception.GlobalException;
import com.wonder.common.result.Result;
import com.wonder.common.result.ResultCodeEnum;
import com.wonder.model.dto.SysUserDto;
import com.wonder.model.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "登录")
@RestController
@RequestMapping("auth")
public class LoginController extends SuperRest {

    @Autowired
    private ISysUserService sysUserService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login(
            @RequestBody SysUser sysUser
            ) {
        Map<String, Object> loginInfo = sysUserService.login(sysUser);
        return Result.ok(loginInfo);
    }

}
