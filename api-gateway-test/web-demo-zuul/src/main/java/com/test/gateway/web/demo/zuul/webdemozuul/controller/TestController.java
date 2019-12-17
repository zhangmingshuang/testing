package com.test.gateway.web.demo.zuul.webdemozuul.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangmingshuang
 * @since 2019/12/12
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/faster")
    @SentinelResource
    public String faster() {
        return "faster";
    }

//    @RequestMapping("/slower")
//    @SentinelResource
//    public String slower() {
//        sleep(100);
//        return "slower";
//    }
//
//
//    @RequestMapping("/slowest")
//    @SentinelResource
//    public String slowest() {
//        sleep(500);
//        return "slowest";
//    }
//
//    private void sleep(int sleep) {
//        try {
//            Thread.sleep(sleep);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
