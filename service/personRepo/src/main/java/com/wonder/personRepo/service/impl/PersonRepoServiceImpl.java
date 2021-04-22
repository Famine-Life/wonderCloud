package com.wonder.personRepo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wonder.common.result.Result;
import com.wonder.model.entity.PersonRepo;
import com.wonder.personRepo.mapper.PersonRepoMapper;
import com.wonder.personRepo.service.IPersonRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wonder
 * @since 2021-04-22
 */
@Service
public class PersonRepoServiceImpl extends ServiceImpl<PersonRepoMapper, PersonRepo> implements IPersonRepoService {

    @Autowired
    private PersonRepoMapper personRepoMapper;

    /**
     * 测试分页
     * @return
     */
    @Override
    public IPage<PersonRepo> test(Integer index, Integer size) {
        //分页对象，构造函数传入当前页数和每页条数
        Page selectPage = new Page<PersonRepo>(index, size);
        //是否查询总条数，默认为true，也可以通过构造函数传入
        //selectPage.setSearchCount(false);
        //封装查询条件
        Wrapper wrapper = new QueryWrapper<PersonRepo>();
        Page page = personRepoMapper.selectPage(selectPage, wrapper);
        return page;
    }
}
