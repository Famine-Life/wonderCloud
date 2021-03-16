package com.wonder.auth.personRepoClient;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 断路器
 */
@Component
public class personRepoHystrix implements personRepoClient {
    @Override
    public Map test() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg","触发断路器了~~~");
        return map;
    }
}
