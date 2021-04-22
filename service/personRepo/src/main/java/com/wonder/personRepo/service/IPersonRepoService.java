package com.wonder.personRepo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wonder.common.result.Result;
import com.wonder.model.entity.PersonRepo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wonder
 * @since 2021-04-22
 */
public interface IPersonRepoService extends IService<PersonRepo> {

    IPage<PersonRepo> test(Integer index, Integer size);


}
