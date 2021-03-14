package com.wonder.personRepo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("personRepo")
public class testController {

    @GetMapping("/test")
    public Map test(){
        Map<String, Object> map = new HashMap<>();
        map.put("test","this is a PersonRepo service TEST!!!");
        return map;
    }

}
