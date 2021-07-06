package com.wonder.auth.controller;

import com.wonder.auth.service.ISysUserService;
import com.wonder.common.base.SuperRest;
import com.wonder.common.exception.GlobalException;
import com.wonder.common.result.Result;
import com.wonder.common.result.ResultCodeEnum;
import com.wonder.model.dto.SysUserDto;
import com.wonder.model.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("auth")
public class LoginController extends SuperRest {

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("/login")
    public Result login(
            @RequestBody SysUser sysUser
            ) {
        Map<String, Object> loginInfo = sysUserService.login(sysUser);
        return Result.ok(loginInfo);
    }

}
