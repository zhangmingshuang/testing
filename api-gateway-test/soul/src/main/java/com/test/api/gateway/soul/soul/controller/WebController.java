package com.test.api.gateway.soul.soul.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.dromara.soul.client.common.annotation.SoulClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangmingshuang
 * @since 2019/12/12
 */
@RestController
@RequestMapping("/web")
public class WebController {

    @RequestMapping("/test")
    @SoulClient(path = "/web/test", desc = "测试")
    @SentinelResource
    public String test() {
        return "Test";
    }

}
