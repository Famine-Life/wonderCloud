package com.wonder.auth.personRepoClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Repository
@FeignClient(name = "personRepo",fallback = personRepoHystrix.class)
public interface personRepoClient {

    @GetMapping("/personRepo/test")
    public Map test();
}
