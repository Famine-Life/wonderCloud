package com.wonder.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wonder.model.entity.SysUser;

import java.util.Map;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author wonder
 * @since 2021-07-04
 */
public interface ISysUserService extends IService<SysUser> {

    Map<String,Object> login(SysUser sysUser);
}
