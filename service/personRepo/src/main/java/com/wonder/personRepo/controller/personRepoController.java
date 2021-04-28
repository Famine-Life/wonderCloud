package com.wonder.personRepo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wonder.common.result.Result;
import com.wonder.model.entity.PersonRepo;
import com.wonder.personRepo.mapper.PersonRepoMapper;
import com.wonder.personRepo.service.IPersonRepoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("personRepo")
public class personRepoController {

    @Autowired
    private IPersonRepoService personRepoService;

    /**
     * 返回所有仓库信息、、
     * @return
     */
    @GetMapping("/personRepoList")
    public Result personRepoList(){
        List<PersonRepo> personRepos = personRepoService.list();
        log.info("personRepoList获取仓库信息:");
        personRepos.stream().forEach(System.out::println);
        return Result.ok(personRepos);
    }


    /**
     * 返回所有仓库分页信息
     * 测试maper.xml是否生效
     * @return
     */
    @GetMapping("/personRepoListPage")
    public Result tt(){
        IPage<PersonRepo> PersonReposPage = personRepoService.test(1,50);
        log.info("ttttttttttttttttt+"+PersonReposPage);
        return Result.ok(PersonReposPage);
    }

}
