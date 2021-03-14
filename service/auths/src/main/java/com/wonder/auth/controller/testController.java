package com.wonder.auth.controller;

import com.wonder.auth.personRepoClient.personRepoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class testController {

    @Autowired
    private personRepoClient personRepoClient;

    @GetMapping("test")
    public Map test(){
        //feign调用
        Map test = personRepoClient.test();
        test.put("PS:","这里是auth Service~  上面的信息是Feign调用了PersonRepo service!");
        return test;
    }

}
