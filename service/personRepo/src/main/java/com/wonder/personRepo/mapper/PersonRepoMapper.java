package com.wonder.personRepo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wonder.model.entity.PersonRepo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wonder
 * @since 2021-04-22
 */
@Mapper
public interface PersonRepoMapper extends BaseMapper<PersonRepo> {

    List<PersonRepo> test();

}
