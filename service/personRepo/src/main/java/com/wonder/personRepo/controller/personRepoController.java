package com.wonder.personRepo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wonder.common.result.Result;
import com.wonder.model.entity.PersonRepo;
import com.wonder.personRepo.config.RedisUtil;
import com.wonder.personRepo.service.IPersonRepoService;
import com.wonder.personRepo.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("personRepo")
public class personRepoController {

    @Autowired
    private IPersonRepoService personRepoService;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private RedisService redisService;
    @Autowired
    private RedisUtil redisUtil;
    /**
     * 返回所有仓库信息、、
     * @return
     */
    @GetMapping("/personRepoList")
    public Result personRepoList(){
        if(redisUtil.hasKey("person-repo-list")){
            Object o = redisUtil.get("person-repo-list");
            log.info("======获取到person-repo-list值======"+o);
            return Result.ok(o);
        }
        List<PersonRepo> personRepos = personRepoService.list();
        //存入redis
        redisUtil.set("person-repo-list",personRepos,1000*60*60*24);
//        log.info("personRepoList获取仓库信息:");
//        personRepos.stream().forEach(System.out::println);
        return Result.ok(personRepos);
    }

    /**
     * 增加或者更新
     * @param personRepo
     * @return
     */
    @PostMapping("/personRepo")
    public Result postPersonRepo(
            @RequestBody PersonRepo personRepo
            ){
        boolean b = personRepoService.saveOrUpdate(personRepo);
        if(!b){
            return Result.fail();
        }
        return Result.ok();
    }

    /**
     * 返回所有仓库分页信息
     * 测试maper.xml是否生效
     * @return
     */
    @GetMapping("/personRepoListPage")
    public Result tt(
            @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex,
            @RequestParam(value = "pageSize",required = false,defaultValue = "20") Integer pageSize
    ){
        IPage<PersonRepo> PersonReposPage = personRepoService.test(1,50);
        log.info("ttttttttttttttttt+"+PersonReposPage);
        return Result.ok(PersonReposPage);
    }

}
