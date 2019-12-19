package com.test.configload;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhangmingshuang
 * @since 2019/12/19
 */
@Component
public class Config1234Compenter {

    @Value("${file.1234Config_1:none}")
    private String config1;
    @Value("${file.1234Config_2:none}")
    private String config2;
    @Value("${file.1234Config_3:none}")
    private String config3;
    @Value("${file.1234Config_4:none}")
    private String config4;

    @PostConstruct
    public void print() {
        System.out.println(this.getClass().getName() + ">>config>>1234Config_1: " + config1 + ""
                               + ",1234Config_2: " + config2
                               + ",1234Config_3: " + config3
                               + ",1234Config_4: " + config4);
    }
}
