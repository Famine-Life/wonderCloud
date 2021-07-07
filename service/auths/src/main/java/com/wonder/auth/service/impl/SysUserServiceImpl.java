package com.wonder.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wonder.auth.mapper.SysUserMapper;
import com.wonder.auth.service.ISysUserService;
import com.wonder.common.exception.GlobalException;
import com.wonder.common.helper.JwtHelper;
import com.wonder.common.result.ResultCodeEnum;
import com.wonder.model.dto.SysUserDto;
import com.wonder.model.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author wonder
 * @since 2021-07-04
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private ISysUserService sysUserService;

    @Override
    public Map<String,Object> login(SysUser sysUser){

        String userName = sysUser.getUserName();
        String password = sysUser.getPassword();
        //查询数据库
        SysUser one = sysUserService.lambdaQuery()
                .eq(SysUser::getUserName, userName)
                .eq(SysUser::getPassword, password)
                .one();
        SysUserDto build = one.build(SysUserDto.class);
        //账号或者密码错误
        if(one == null){
            throw new GlobalException(ResultCodeEnum.PARAM_ERROR);
        }

        //返回用户登录信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("UserDto",build);
        //jwt生成token
        String token = JwtHelper.createToken(one.getId(), one.getUserName());
        map.put("token",token);

        return map;

    }

}
