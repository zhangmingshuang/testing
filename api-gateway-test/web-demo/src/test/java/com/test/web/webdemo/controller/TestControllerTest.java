package com.test.web.webdemo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhangmingshuang
 * @since 2019/12/12
 */
@SpringBootTest
public class TestControllerTest {

    @Autowired
    private TestController testController;

    @Test
    public void test() {
        String faster = testController.faster();
        String slower = testController.slower();
        String slowest = testController.slowest();
    }
}
