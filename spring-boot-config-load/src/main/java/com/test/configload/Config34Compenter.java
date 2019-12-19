package com.test.configload;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 测试当前目录下的配置文件与当前目录下config子目录配置文件的加载顺序
 *
 * note: 当前目录特指运行时目录，System.getProperty("user.dir")下
 * 也就是与jar包同级目录下
 *
 * @author zhangmingshuang
 * @since 2019/12/19
 */
@Component
public class Config34Compenter {

    @Value("${file.34Config_1:none}")
    private String config1;
    @Value("${file.34Config_2:none}")
    private String config2;

    @PostConstruct
    public void print() {
        System.out.println(this.getClass().getName() + ">>config>>34Config_1: " + config1 + ",34Config_2: " + config2);
    }
}
