package com.test.web.webdemo.controller;

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
    public String faster() {
        return "faster";
    }

    @RequestMapping("/slower")
    public String slower() {
        sleep(100);
        return "slower";
    }


    @RequestMapping("/slowest")
    public String slowest() {
        sleep(500);
        return "slowest";
    }

    private void sleep(int sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
