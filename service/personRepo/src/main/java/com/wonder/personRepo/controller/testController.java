package com.wonder.personRepo.controller;

import com.wonder.common.result.Result;
import com.wonder.model.entity.PersonRepo;
import com.wonder.personRepo.mapper.PersonRepoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("personRepo")
public class testController {

    @Autowired
    private PersonRepoMapper personRepoMapper;

    @GetMapping("/test")
    public Map test(){
        Map<String, Object> map = new HashMap<>();
        map.put("test","this is a PersonRepo service TEST!!!");
        List<PersonRepo> personRepos = personRepoMapper.selectList(null);
//        personRepo personRepo = new personRepo();
//        personRepoMapper.insert(personRepo);      //自动填充字段测试。
        map.put("list",personRepos);
        return map;
    }

}
